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
        <#list reviews as review>
            <div class="row ${review?item_parity} flex">
                <div class="column">
                    ${review.reviewer}
                </div>
<#--                <div class="column">-->
<#--                    <#list review.reviewer as rev>-->
<#--                        ${rev.name}-->
<#--                    </#list>-->
<#--                </div>-->
                <div class="column">
                    ${review.stars}
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>