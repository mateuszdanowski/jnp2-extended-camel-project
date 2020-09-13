# Projekt zaliczeniowy JNP2

Rozszerzenie małego zadania.

## Działanie programu
Folder o nazwie filesForKafka jest obserwowany na dodawanie oraz modyfikacje plików.
Podobnie jak w małym zadaniu, kafka otrzymuje wiadomość JSON z tymi samymi informacjami.
Następnie wiadomość ta jest wysyłana na serwer HTTP metodą POST, a serwer zapisuje ją do bazy danych.
W tle działa również timer, który co dwie sekundy uruchamia metodę, która tworzy nowy plik w folderze filesForKafka, dzięki czemu łatwo widać jak wszystko działa.
Wchodząc pod adres localhost:8080/messages widać wszystkie otrzymane przez serwer wiadomości.

## Budowanie
```
docker-compose up

kafka-topics --create --zookeeper localhost:2181 --topic jnp2-fileToKafka --replication-factor 1 --partitions 1

kafka-console-consumer --bootstrap-server localhost:9092 --topic jnp2-fileToKafka --from-beginning
```

## Uruchamianie
```
mvn clean install

mvn spring-boot:run
```

## Na koniec
```
docker-compose down
```