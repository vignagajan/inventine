<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
        *{
            transition: all 0.6s;
        }

        html {
            height: 100%;
        }

        body{
            font-family: 'Poppins', sans-serif;
            color: #0097E6;
            margin: 0;
        }

        #main{
            display: table;
            width: 100%;
            height: 100vh;
            text-align: center;
        }

        .fof{
            display: table-cell;
            vertical-align: middle;
        }

        .fof h1{
            font-size: 150px;
            display: inline-block;
            padding-right: 12px;
            animation: type .5s alternate infinite;
        }

        @keyframes type{
            from{box-shadow: inset -3px 0px 0px #0097E6;}
            to{box-shadow: inset -3px 0px 0px transparent;}
        }
    </style>
</head>
<body>
<div id="main">
    <div class="fof">
        <h1>Error 404</h1>
    </div>
</div>
</body>
</html>