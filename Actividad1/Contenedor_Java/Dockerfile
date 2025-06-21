FROM openjdk:17 as builder
WORKDIR /app
COPY App.java .
RUN javac App.java

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/App.class .
EXPOSE 5000
CMD ["java", "App"]