package com.agu.coffeeshop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "history")
public class History {

    @Id
    private String id;
    private Instant timestamp;
    private String userName;
    private String userEmail;
    private HistoryAction historyAction;
    private String parentId;
    private String comments;
    private List<Change> changeLog;

    public enum HistoryAction {
        COMPOSE, UPDATE, DELETE
    }

    @Data
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    public static class Change {
        private String fieldName;
        private String oldValue;
        private String updatedValue;
    }
}
