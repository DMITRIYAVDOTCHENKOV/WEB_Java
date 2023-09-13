FROM bellsoft/liberica-openjdk-alpine:11.0.16
COPY ./java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/avdotchenkov/docker/sample/Main.java
CMD java -classpath ./out avdotchenkov.docker.sample.Main
