<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>КиноЗал</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<body>
<a href="/audiences"> Ко всем зрителям</a>
<br>
<a href="/films">Ко всем фильмам</a>
<br>
<a href="/cinemaHalls">Ко всем Кинозалам</a>
<br>
<br>
<h3>Зал</h3>
<br>
<form action="/cinemaHalls/${cinemaHall.id}/update" method="post">
    <label>
        Название зала
        <textarea name="title">${cinemaHall.title}</textarea>
    </label>
    <br>
    <label>
        Содержание
        <textarea name="description">${cinemaHall.description}</textarea>
    </label>
    <br>
    <label>
        Начало фильма
        <input type="date" name="start" value=${cinemaHall.start}>
    </label>
    <br>
    <label>
        Окончание фильма
        <input type="date" name="finish" value=${cinemaHall.finish}>
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
<h4>Фильмы в зале</h4>
<br>
<table>
    <tr>
        <th>Название фильма</th>
        <th>Описание фильма</th>
        <th>Убрать фильм из зала</th>
        <th>Перейти</th>
    </tr>
    <#list inCinemaHallFilms as film>
        <tr>
            <td>${film.name}</td>
            <td>${film.summary}</td>
            <td><a href="/cinemaHalls/${cinemaHall.id}/remove?film-id=${film.id}">Убрать</a></td>
            <td><a href="/film/${film.id}">Перейти</a></td>
        </tr>
    </#list>
</table>
<form action="/cinemaHalls/${cinemaHall.id}/films" method="post">
    <label>Фильмы
        <select name="film-id">
            <#list notInCinemaHallFilms as film>
                <option value="${film.id}">${film.name} ${film.summary}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Добавить">
</form>
<h2>Зрители в зале</h2>
<br>
<table>
    <tr>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Перейти</th>
    </tr>
    <#list inCinemaHallAudiences as audience>
        <tr>
            <td>${audience.email}</td>
            <td>${audience.firstName}</td>
            <td>${audience.lastName}</td>
            <td><a href="/audiences/${audience.id}">Перейти</a></td>
        </tr>
    </#list>
</table>
<form action="/cinemaHalls/${cinemaHall.id}/audiences" method="post">
    <br>
    <label>Зрители
        <select name="audience-id">
            <#list notInCinemaHallsAudiences as audience>
                <option value="${audience.id}">${audience.firstName} ${audience.lastName}</option>
            </#list>
        </select>
    </label>
    <br>
    <input type="submit" value="Добавить">
</form>
</body>
</html>