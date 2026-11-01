# ФИО
Ли Александр Геннадьевич

# Название и версия исследуемой библиотеки/фреймворка
- Стек: Backend, Java
- Библиотека: Hibernate 7.2.12
- Исследуемый механизм: Persistence Context (кэш первого уровня, ActionQueue, Dirty Checking, Lazy Loading)
- Репозиторий github: https://github.com/hibernate/hibernate-orm

# Инструкция запуска
Для запуска необходимы JDK 25 и Maven. При разработке использовалась версия Maven 3.9.16
Из корневой папки нужно прописать ```mvn clean package```, а затем ```java -jar .\target\hibernate-demo-4.0.6.jar```