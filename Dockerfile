FROM adoptopenjdk:11.0.8_10-jre-hotspot
VOLUME /tmp
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT exec java $JAVA_ARGS -cp app:app/lib/* com.ldd.lrtservices.LRTServicesApplication
