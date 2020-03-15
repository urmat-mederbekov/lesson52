<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Reviews</title>
    <link href="/css/freemarker.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="table flex flex-col">
        <div class="header flex">
            <div class="column">
                Title
            </div>
            <div class="column">
                Actors
            </div>
            <div class="column">
                Directors
            </div>
            <div class="column">
                Release year
            </div>
            <div class="column">
                Rating
            </div>
        </div>
        <#list users as user>
            <div class="row ${user?item_parity} flex">
                <div class="column">
                    ${user.name}
                </div>
                <div class="column">
                    ${user.email}
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>