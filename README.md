# API Documentation

## Введение

Добро пожаловать в документацию нашего API Этот документ предназначен для предоставления информации о доступных конечных точках, их параметрах и возвращаемых данных.

## Авторизация

### `/api/csrf`

#### Описание
Получение CSRF токена необходимо для по сути любого post запроса, действителен одну сессию (до выхода с вкладки или выхода из аккаута, потом нужен новый)
Обычна сессия начинается с него, так же с ним приходят куки спринга, их нужно оставить у себя и предавать с каждым следующим запросом как и сам токен.
#### Метод
- **GET**: Получить новый токен.

#### Пример ответа
```json
{
"token": "токен"
}
```

### `/api/login`

#### Описание
Вход в апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена <br>(в теории если уже залогинены может кинуть и 403)
#### Метод
- **POST**: Войти в приложение

#### Параметры
- **username**: Логин пользователя.
- **password**: Пароль пользователя.

#### Примеры ответа
```json
{
  "result": "all_ok"
}
```
```json
{
  "message": "Invalid username or password", "code": 400
}
```
```json
{
  "message": "Please logout first.", "code": 400
}
```

### `/api/logout`

#### Описание
Выход из апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **POST**: Выйти из приложения

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/current-user`

#### Описание
Получить текущего пользователя<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Получить инормацию о пользователе

#### Пример ответа
```json
{
  "username": "qwet", 
  "email": "a@a.a", 
  "name": "Иванов Иван Иванович", 
  "role": "Штатный дебил", 
  "dateOfRegistration": "2024-10-12T23:47:14.949381", 
  "admin": true
}
```

### `/api/signup`

#### Описание
Зарегестироваться в апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена
#### Метод
- **POST**: Зарегестировать нового пользователя

#### Параметры
- **username**: Логин пользователя.
- **password**: Пароль пользователя.
- **email**: Email пользователя.
- **name**: Имя пользователя.
- **role**: Должность пользователя (не путать с флагом админ).

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

## Тестовые запросы для ребят с бека (тут отличается реализация, нужно посмотреть в код), фронт при желании может потестить их

### `/api/test`

#### Описание
Тестовый запрос доступ к которому имеют авторизированные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Общий тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с общим доступом

Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил
```

### `/api/test-user`

#### Описание
Тестовый запрос доступ к которому имеют только обычные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Только пользовательский тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с доступом только пользователя


Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил и он пользователь
```

### `/api/test-admin`

#### Описание
Тестовый запрос доступ к которому имеют авторизированные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Только админский тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с доступом только админа


Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил и он админ
```

### `/api/admin/createCourse`

#### Описание
Создает новый курс.<br>
Проверяет на null
#### Метод
- **POST**: Создать новый курс

#### Параметры
- **title**: Название курса.
- **dateOfCreation**: Дата создания курса.
- **description**: Описание курса.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/createEmulation`

#### Описание
Создает новую эмуляцию.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую эмуляцию

#### Параметры
- **private_title**: Название эмуляции.
- **dateOfCreation**: Дата создания эмуляции.
- **timerTime**: Таймер для задачи.
- **timerDescription**: Описание таймера для задачи.
- **screenImageURL**: Ссылка на изображение.
- **blockSchemeJSON**: JSON-файл с блок-схемой.
- **blockCodeJS**: Код для эмуляции на JS.
- **byteArrayInterface**: Дамп интерфейса в виде байт-кода.
- **task**: Задача.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/createTask`

#### Описание
Создает новую задачу.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую задачу

#### Параметры
- **title**: Название задачи.
- **dateOfCreation**: Дата создания задачи.
- **description**: Описание задачи.
- **lessonTitle**: Название связанного урока.
- **courseTitle**: Название связанного курса.
- **emulation**: Эмуляция.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/createTheme`

#### Описание
Создать новую тему.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую тему

#### Параметры
- **title**: Название темы.
- **dateOfCreation**: Дата создания темы.
- **title**: Описание темы.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/createThemeMaterial`

#### Описание
Добавить учебные материалы для темы.<br>
Проверяет на null
#### Метод
- **POST**: Добавить учебные материалы

#### Параметры
- **title**: Название учебных материалов.
- **materialType**: Тип учебных материалов.
- **materialURL**: Ссылки на исходные и дополнительные источники.
- **materialText**: Текстовое поле для информации.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```