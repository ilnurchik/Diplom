<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Зрители</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<body>
<a href="/films">Ко всем фильмам</a>
<br>
<a href="/cinemaHalls">Ко всем залам</a>
<br>
<br>
<h2>Зрители</h2>
<br>
<table>
    <tr>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Перейти</th>
        <th>Удалить</th>
    </tr>
    <#list audiencesList as audience>
        <tr>
            <td>${audience.email}</td>
            <td>${audience.firstName}</td>
            <td>${audience.lastName}</td>
            <td><a href="/audiences/${audience.id}">Перейти</a></td>
            <td><a href="/audiences/${audience.id}/delete">Удалить</a></td>
        </tr>
    </#list>
</table>
<form action="/audiences" method="post">
    <br>
    <label>
        Email
        <input type="email" name="email" placeholder="Введите почту">
    </label>
    <br>
    <label>
        Имя
        <input type="text" name="firstName" placeholder="Введите имя">
    </label>
    <br>
    <label>
        Фимилия
        <input type="text" name="lastName" placeholder="Введите фамилию">
    </label>
    <br>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</body>
</html>