<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильмы</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<body>
<a href="/audiences">Ко всем зрителям</a>
<br>
<a href="/cinemaHalls">Ко всем залам</a>
<br>
<br>
<h2>Фильмы</h2>
<br>
<table>
    <tr>
        <th>Название фильма</th>
        <th>Описание фильма</th>
        <th>Перейти</th>
        <th>Удалить</th>
    </tr>
    <#list films as film>
        <tr>
            <td>${film.name}</td>
            <td>${film.summary}</td>
            <td><a href="/films/${film.id}">Перейти</a></td>
            <td><a href="/films/${film.id}/delete">Удалить</a></td>
        </tr>
    </#list>
</table>
<form action="/films" method="post">
    <br>
    <label>
        Название фильма
        <input type="text" name="name" placeholder="Введите сюда">
    </label>
    <br>
    <label>
        Описание фильма
        <input type="text" name="summary" placeholder="Введите сюда">
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</body>
</html>