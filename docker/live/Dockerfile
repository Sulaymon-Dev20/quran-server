#
# build without build
#
FROM openjdk:17-oracle
COPY --from=build /home/app/target/quran-0.0.1-SNAPSHOT.jar /usr/local/lib/application.jar
EXPOSE 6236
ENTRYPOINT ["java", "-jar", "/usr/local/lib/application.jar"]
