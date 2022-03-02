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

        <%--https://css-tricks.com/responsive-data-tables/--%>
        @media
        only screen and (max-width: 760px),
        (min-device-width: 768px) and (max-device-width: 1024px)  {

            /* Force table to not be like tables anymore */
            table, thead, tbody, th, td, tr {
                display: block;
            }

            /* Hide table headers (but not display: none;, for accessibility) */
            thead tr {
                position: absolute;
                top: -9999px;
                left: -9999px;
            }

            tr { border: 1px solid #ccc; }

            td {
                /* Behave  like a "row" */
                border: none;
                border-bottom: 1px solid #eee;
                position: relative;
                padding-left: 10em;
            }

            td:before {
                /* Now like a table header */
                position: absolute;
                /* Top/left values mimic padding */
                top: 6px;
                left: 8px;
                width: 45%;
                padding-right: 10px;
                white-space: nowrap;
            }

            /*
            Label the data
            */
            td:nth-of-type(1):before { content: "Sprite"; }
            td:nth-of-type(2):before { content: "Pokedex"; }
            td:nth-of-type(3):before { content: "Name"; }
            td:nth-of-type(4):before { content: "Type1"; }
            td:nth-of-type(5):before { content: "Type2"; }
            td:nth-of-type(6):before { content: "HP"; }
            td:nth-of-type(7):before { content: "Attack"; }
            td:nth-of-type(8):before { content: "Defense"; }

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