FROM openjdk:8u181-alpine3.8

WORKDIR /

COPY target/uberjar/clojure_example-0.1.0-SNAPSHOT-standalone.jar clojure_example.jar
COPY .env.development .env.development
EXPOSE 3000

CMD java -jar clojure_example.jar
