<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Кинозалы</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<body>
<br>
<a href="/audiences">Ко всем зрителям</a>
<br>
<a href="/films">Ко всем фильмам</a>
<br>
<br>
<h2>Кинозалы</h2>
<br>
<table>
    <tr>
        <th>Название кинозала</th>
        <th>Содержание кинозала</th>
        <th>Перейти</th>
        <th>Удалить</th>
    </tr>
    <#list cinemaHalls as cinemaHall>
        <tr>
            <td>${cinemaHall.title}</td>
            <td>${cinemaHall.description}</td>
            <td><a href="/cinemaHalls/${cinemaHall.id}">Перейти</a></td>
            <td><a href="/cinemaHalls/${cinemaHall.id}/delete">Удалить</a></td>
        </tr>
    </#list>
</table>
<form action="/cinemaHalls" method="post">
    <label>
        Название кинозала
        <input type="text" name="title" placeholder="Введите название">
    </label>
    <br>
    <label>
        Содержание кинозала
        <input type="text" name="description" placeholder="Введите содержание">
    </label>
    <br>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</body>
</html>