FROM java:8-alpine
MAINTAINER Sean Marsh Glover (MarshHawk)

ADD build/libs/cat-suite-0.0.1.jar /cat-suite/cat-suite-0.0.1.jar

EXPOSE 3534

CMD java -jar /cat-suite/cat-suite-0.0.1.jar $SPRING_SQL_URI $SPRING_SQL_USER $SPRING_SQL_PASS $MONGO_CONNECT_STRING