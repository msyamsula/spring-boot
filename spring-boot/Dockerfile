from fabric8/java-alpine-openjdk11-jre
workdir /app

run ["java", "--version"]
run ["pwd"]
copy ./target/spring-boot-0.0.1-SNAPSHOT.jar ./

cmd ["java", "-jar", "spring-boot-0.0.1-SNAPSHOT.jar"]