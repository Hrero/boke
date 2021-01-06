FROM openjdk:latest

WORKDIR /usr/app

ADD boke.jar /usr/app

ENTRYPOINT ["java" ,"-jar" ,"-Duser.timezone=GMT+08","/usr/app/boke.jar"]
