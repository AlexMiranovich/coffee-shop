package com.agu.coffeeshop.entities;

import com.agu.coffeeshop.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.SneakyThrows;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Function;

import static org.springframework.util.StringUtils.hasText;

@SuppressWarnings("unchecked")
public interface Changeable<T> {

    Gson GSON = GsonUtils.getGsonBuilder().create();

    default List<History.Change> getChanges(T entity) {
        List<History.Change> changes = new ArrayList<>();
        getFields().forEach((fieldName, getter) -> {
            Object otherValue = getValue(entity, getter);
            Object thisValue = getValue((T) this, getter);
            if (isChangeable(thisValue) || isChangeable(otherValue)) {
                addNestedObjectChanges(changes, otherValue, thisValue);
            } else if (!Objects.equals(thisValue, otherValue) && (isPresent(thisValue) || isPresent(otherValue))) {
                boolean hashcode = getHashCodeFieldNames().stream().anyMatch(it -> it.equalsIgnoreCase(fieldName));
                changes.add(History.Change.of(
                        fieldName,
                        processValue(thisValue, hashcode),
                        processValue(otherValue, hashcode))
                );
            }
        });
        return changes;
    }

    Map<String, Function<T, Object>> getFields();

    List<String> getHashCodeFieldNames();

    @SneakyThrows
    private String processValue(Object value, boolean hashCode) {
        JsonElement element = GSON.toJsonTree(value);
        if (element.isJsonNull()) return null;
        if (hashCode) return String.valueOf(element.hashCode());
        if (element.isJsonPrimitive()) return element.getAsString();
        return GSON.toJson(element);
    }

    private boolean isPresent(Object value) {
        if (Objects.isNull(value)) return false;
        if (!hasText(value.toString())) return false;
        boolean isArray = value.getClass().isArray();
        boolean isCollection = Collection.class.isAssignableFrom(value.getClass());
        boolean isMap = Map.class.isAssignableFrom(value.getClass());
        if (isArray) return ((Object[]) value).length != 0;
        if (isCollection) return !CollectionUtils.isEmpty((Collection<?>) value);
        if (isMap) return !CollectionUtils.isEmpty((Map<?, ?>) value);
        return true;
    }


    private boolean isChangeable(Object value) {
        if (value == null) return false;
        return Changeable.class.isAssignableFrom(value.getClass());
    }

    private Object getValue(T entity, Function<T, Object> getter) {
        if (entity == null) return null;
        return getter.apply(entity);
    }

    private void addNestedObjectChanges(List<History.Change> changes, Object entityValue, Object thisValue) {
        try {
            if (thisValue == null && entityValue == null) return;
            if (thisValue == null) {
                thisValue = entityValue.getClass().getDeclaredConstructor().newInstance();
            }
            Object result = Changeable.class.getMethod("getChanges", Object.class)
                    .invoke(thisValue, entityValue);
            changes.addAll((Collection<? extends History.Change>) result);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException ignored) {
        }
    }
}
