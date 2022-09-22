# Need: docker for windows

step 1: open cmd 

docker-compose -f docker-compose.yml up -d

expose cli: docker exec -it kafka /bin/sh

cd /opt/kafka_2.13-2.8.1/bin

create topic: kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic demo

show list topic: kafka-topics.sh --bootstrap-server=localhost:9092 --list

step 2: open postman and send a request

```java
GET http://localhost:8080/send
```

output on console

```text
Received Message in group - group-id: kafka
```

Version:

- spring-boot-starter-parent 2.3.0 in *- master -* branch
  
- spring-boot-starter-parent 2.7.2 in *- spring_parent_2_7_2 -* branch


to access kafka manager in UI: http://localhost:9000