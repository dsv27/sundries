# Подготовка и настройка системы для разработки SPARK на SCALA
Установим версию SPARK 2.4.2 и настроим VSC для работы и сборки больших джарников

1. Создадим проект spark c помощью Metals c шаблоном HelloWord (F1 Metals:New Scala Project)
1. Подготавливаем .gitignore

    ```
    .metals/
    .bloop/
    .ammonite/
    metals.sbt

    ### SBT ###
    # Simple Build Tool
    # http://www.scala-sbt.org/release/docs/Getting-Started/Directories.html#configuring-version-control

    dist/*
    target/
    lib_managed/
    src_managed/
    project/boot/
    project/plugins/project/
    .history
    .cache
    .lib/

    # End of https://www.toptal.com/developers/gitignore/api/sbt
    ```

1. Зачищаем build.sbt 

    ```
    scalaVersion := "2.12.12"

    name := "spark"
    organization := "ru.dsv27"
    version := "1.0"


    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
    ```

1. Подготавливаем project/plugins.sbt, для сборки fat jar (модуль sbt-assembly)
    ```
    addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0" )
    resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
    ```
1. Исправляем SimpleApp.scala
1. Добавляем зависимости в buiald.sbt
    ```
    libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.4.1",
    "org.apache.spark" %% "spark-sql" % "2.4.1"
    )
    ```
1. Запускаем в каталоге проекта sbt, затем для сборки 
Файлик находится target/scala-2.12/spark-assembly-1.0.jar

1. Установка рантайма Spark 
```sdk spark 2.4.1```
1. Запуск 
    ```
    spark-submit \
    --class "SimpleApp" \
    --master local[4] \
    /home/dmitrii/sundries/scala/spark/target/scala-2.12/spark-assembly-1.0.jar
    ```
    Результат
    ```
    20/11/23 23:00:14 INFO DAGScheduler: Job 1 finished: count at SimpleApp.scala:9, took 0.042327 s
    Lines with a: 9, Lines with b: 5
    20/11/23 23:00:14 INFO SparkUI: Stopped Spark web UI at http://192.168.99.37:4040
```
1. Дополнительно

Изменить имя jar архива -> ```assemblyJarName in assembly := "baeldung-scala-sbt-assembly-fatjar-1.0.jar"```

Изменить стратегию merga 
    ```
    assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
    }
    ```