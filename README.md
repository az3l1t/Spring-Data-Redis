Во-первых, нужен линукс. Я использую WSL и дистрибутив ubuntu:
Создаем пользователя и вводим команду:
```
sudo apt-add-repository ppa:redislabs/redis
```

```
sudo apt-get update
```

```
sudo apt-get upgrade
```

```
sudo apt-get install redis-server
```

Дальше стоит изменить порт в конфигурационном файле:
```
nano redis.conf
```
Пишем в нем:
```
port 6380
```
Ctrl+0, Enter, Ctrl+X -> сохранить и выйти
Инициализируем проект с зависимостями:
![[Зависимости Redis.png]]
Дальше в проект добавляем новую зависимость:
```
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>5.1.2</version>
</dependency>
