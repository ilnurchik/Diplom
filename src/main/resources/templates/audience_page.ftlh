<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Читатель</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<a href="/audiences"> Ко всем зрителям</a>
<br>
<a href="/films">Ко всем фильмам</a>
<br>
<a href="/cinemaHalls">Ко всем залам</a>
<br>
<br>
<h3>Зритель</h3>
<br>
<form action="/audiences/${audience.id}/update" method="post">
    <br>
    <label>
        Email
        <input type="email" name="email" value=${audience.email}>
    </label>
    <br>
    <label>
        Имя
        <input type="text" name="firstName" value=${audience.firstName}>
    </label>
    <br>
    <label>
        Фимилия
        <input type="text" name="lastName" value=${audience.lastName}>
    </label>
    <br>
    <label>
        Возраст
        <input type="text" name="age" value=${audience.age}>
    </label>
    <br>
    <input autofocus type="submit" value="Сохранить"/>
</form>
<body>
</body>
</html>