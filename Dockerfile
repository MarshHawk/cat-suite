FROM java:8-alpine
MAINTAINER Sean Marsh Glover (MarshHawk)

ADD build/libs/cat-suite-0.0.1-SNAPSHOT.jar /cat-suite/cat-suite-0.0.1-SNAPSHOT.jar

EXPOSE 8000

CMD ["java", "-jar", "/cat-suite/cat-suite-0.0.1-SNAPSHOT.jar"]