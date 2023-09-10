# Проект Сервиса библиотеки

### Описание проекта

Данный проект позволяет работать с несколькими связанными таблицами:

- таблица с информацией об авторах,
- таблица с информацией о книгах, которые имеются в библиотеке.
  Каждая книга связана с автором, также содержится информация о пользователе, который в данный момент читает выбранную
  книгу.

С помощью данного сервиса Вы можете получить списки с информацией, которая хранится в базе данных
через get запросы с
использованием параметров:

- информация обо всех книгах автора, которые записаны в базе данных библиотеки;

Имеется возможность отправить по сети и записать данные в БД через post запросы:

- информация о новых авторах;
- информация о новых книгах.

Сервис также позволяет получить из справочника данные о читателях библиотеки.

### Запуск приложения

- Перейдите в pom.xml и соберите проект.
- Скачайте плагин Docker
- Перейдите к файлу docker-compose.yaml.
  Запустите файл. Все конфигурации, необходимые для подключения к базе данных указаны в текущем
  файле
  Хост: localhost
- Перейдите в файл Library Application. Запустите приложение.
  Убедитесь, что приложение успешно запустилось:
  В консоли нет ошибок. Появилась запись: StartupInfoLogger: Started LibraryApplication.

### Используемые технологии

- Maven
- Spring
- MySql
- JUnit

### Описание работы с проектом

Все методы (кроме запроса токена) требуют хэдера авторизации.
```
curl --location 'http://localhost:8080/library/authors/2/books' \
--header 'Authorization: Bearer ...'
```
В случае отсутствия токена будет получен 403 код ошибки.

Запрос получения jwt-токена:

```
curl --location --request GET 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
"login": "master_log",
"password": "qweasdzxc"
}'
```

Пример post запроса для сохранения новой книги в базе данных:

```
POST http://localhost:8080/library/books/save
Content-Type: application/json

{
  "bookTitle": "Два гусара",
  "author": {
    "id": 2
  }
}
```

Пример post запроса для сохранения нового автора в базе данных:

```
POST http://localhost:8080/library/authors/save
Content-Type: application/json

{
  "firstName": "Николай",
  "secondName": "Гумилев"
}
```

Пример get запроса для получения всех книг автора

```
GET http://localhost:8080/library/authors/2/books
```

Пример post запроса для получения всех книг автора (xml формат)

```
POST http://localhost:8080/library/authors/books
Content-Type: application/xml

<author>
    <author_id>2</author_id>
</author>
```

Пример get запроса для получения всех читателей из справочника

```
GET http://localhost:8080/customer/customers
```

### Требования к практической работе

Необходимо протестировать методы:

- POST http://localhost:8080/library/authors/save
- POST http://localhost:8080/library/books/save
- GET http://localhost:8080/library/authors/{id}/books
- POST http://localhost:8080/library/authors/books
- GET http://localhost:8080/customer/customers/{filter}
  с использованием Hibernate, Rest-assured, JUnit, Lombok

Архитектура описана в src/main/resources/LibraryService.png

## Автор проекта

Кряжова Светлана Юрьевна
