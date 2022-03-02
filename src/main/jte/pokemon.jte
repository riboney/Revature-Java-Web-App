@import app.models.Pk
@param app.models.Pk pokemon

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
    <style>
        th, td {
            text-align: center;
            vertical-align: middle;
        }

        td {
            font-weight: bold;
        }

        .centerChildren {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .childrenBody {
            margin: 10% auto;
        }

        button:hover{
            background-color: #41adff;
        }
    </style>
</head>

<body>
    <div class="centerChildren">
        <h2>${pokemon.getName()}</h2>

        <div class="childrenBody">
            <table>
                <thead>
                <tr>
                    <th>Sprite</th>
                    <th>Pokedex</th>
                    <th>Name</th>
                    <th>Type1</th>
                    <th>Type2</th>
                    <th>HP</th>
                    <th>Attack</th>
                    <th>Defense</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><img src="${pokemon.getImageURL().toString()}"></td>
                    <td>${Integer.toString(pokemon.getPokedex())}</td>
                    <td>${pokemon.getName()}</td>
                    <td>${pokemon.getType1().toString()}</td>
                    <td>${pokemon.getType2().toString()}</td>
                    <td>${Integer.toString(pokemon.getHp())}</td>
                    <td>${Integer.toString(pokemon.getAttack())}</td>
                    <td>${Integer.toString(pokemon.getDefense())}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <button onclick="location.href='/';" >Back</button>
    </div>
</body>
</html>