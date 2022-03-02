@param String error

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <style>
        .centerChildren {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding-top: 5% 0;
        }
    </style>
</head>

<body>
    <div class="centerChildren">
        <h1>Uh oh, error!</h1>
        <div>
            <img src="https://i.kym-cdn.com/photos/images/original/001/431/201/40f.png" height="100" width="100">
        </div>
        <h3>${error}</h3>
        <button onclick="location.href='/';" >Back</button>
    </div>
</body>
</html>