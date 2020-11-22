# Установка VSCode Scala remote
Необходимо обеспечить работоспособность VSCode в режиме remote на linux системе

Статья по установке [1] 

Необходимо sbt, metals, bloop

## Установка [SDKMAN][3]
Устанавливаем согласно [документации][4]
1. Запускаем 
```curl -s "https://get.sdkman.io" | bash ```следуем инструкциям
2. Настройка окружения
```source "/home/dmitrii/.sdkman/bin/sdkman-init.sh"```
4. Проверка работоспособности
    ```sdk help```

## Установка SBT

Делаем по [доке][2]

1. Устанавливаем java с помощью sdkman ```sdk install java 11.0.9.hs-adpt```
Результат 
```
~$ java -version
openjdk version "11.0.9.1" 2020-11-04
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.9.1+1)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.9.1+1, mixed mode)
```
2. Установка sbt
```sdk install sbt```
Результат 
```sbt -version```
```
...
sbt version in this project: 1.4.3
sbt script version: 1.4.3
```

## Устанавливаем Scala , [с помощью sbtman][5]
1. Установка 
```https://www.scala-lang.org/download/```
2. Проверка версии
```scala -version```
Ответ
```
Scala code runner version 2.12.12 -- Copyright 2002-2020, LAMP/EPFL and Lightbend, Inc.
```

## Установка Metals 
Metals устанавливается из marekplace, из раздела VSC extentions 


## Разработка в VSC для Scala

### Создание проекта
Из меню Metals необходимо выбрать шаблон. Проект создается автоматически



[1]: https://habr.com/ru/post/469707/ "Статья на хабр"
[2]: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html "Статья по установке SBT"
[3]: https://sdkman.io/ "Менеджер SDK"
[4]: https://sdkman.io/install "Инсталяция SDKMAN"
[5]: https://www.scala-lang.org/download/ "Инсталяцция SCALA"
