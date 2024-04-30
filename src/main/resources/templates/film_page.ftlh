<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильм</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css">
</head>
<body>
<a href="/audiences"> Ко всем зрителям</a>
<br>
<a href="/films">Ко всем фильмам</a>
<br>
<a href="/cinemaHalls">Ко всем залам</a>
<br>
<br>
<h3>Фильм</h3>
<br>
<form action="/films/${film.id}/update" method="post">
    <label>
        Название фильма
        <textarea name="name"> ${film.name}</textarea>
    </label>
    <br>
    <label>
        Описание фильма
        <textarea name="summary"> ${film.summary}</textarea>
    </label>
    <br>
    <label>
        Начало сеанса
        <input type="time" name="startTime" value=${film.startTime}>
    </label>
    <br>
    <label>
        Окончание сеанса
        <input type="time" name="finishTime" value=${film.finishTime}>
    </label>
    <br>
    <input type="submit" value="Сохранить"/>
</form>
</body>
</html>