@import app.models.Pk
@import app.utils.PkType
@import java.util.List
@param List<Pk> pokemons
@param String currentFilter

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

        h1 {
            text-align: center;
        }

        th, td {
            text-align: center;
            vertical-align: middle;
            width: 10em;
        }

        td {
            font-weight: bold;
        }

        .verticalSpacing {
            margin-top: 5%;
        }

        .clickable:hover {
            cursor: pointer;
            background-color: #41adff;
        }

        button:hover{
            background-color: #41adff;
        }

        select {
            margin: auto;
        }

        option {
            text-align: center;
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
                position: relative;
                padding-left: 10em;
            }

            td:before {
                /* Now like a table header */
                position: absolute;
                /* Top/left values mimic padding */
                top: 6px;
                left: 6px;
                width: 45%;
                padding-right: 2em;
                white-space: nowrap;
            }

            /*
            Label the data
            */
            td:nth-of-type(1):before { content: "Pokedex"; }
            td:nth-of-type(2):before { content: "Name"; }
        }
    </style>
</head>

<body>
<div class="centerChildren">
    <h1>Welcome to the PokeDex!</h1>

    <div class="verticalSpacing">
        <img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Pok%C3%A9ball.png" height="100" width="100">
    </div>

    <div class="centerChildren">
        <h3>Enter Pokemon name</h3>
        <form method="post" action="/pokemon" class="centerChildren">
            <input type="text" name="name" required>
            <button type="submit">search</button>
        </form>
        <%--src: https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/radio#styling_radio_inputs--%>
        <form id="typeForm" method="post" action="/">
            <h3>Filter Pokemons by Type</h3>
            <%--https://stackoverflow.com/a/7231215--%>
            <select name="type" id="type-select" onchange="this.form.submit()">
                <option name="type">Select type</option>
                <option name="type" value="all">
                    all
                </option>
                @for(PkType type: PkType.values())
                    @if(!type.toString().equalsIgnoreCase("none"))
                        <option name="type" value="${type.toString()}">
                            ${type.toString().toLowerCase()}
                        </option>
                    @endif
                @endfor
            </select>
        </form>
    </div>

    <em>Currently displaying <span style="text-decoration: white underline;">${currentFilter}</span> pokemons...</em>

    <div class="verticalSpacing">
        <table>
            <thead>
            <tr>
                <th>Pokedex</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            @for(Pk pokemon: pokemons)
                <%--https://stackoverflow.com/a/17147876--%>
                <tr class="clickable" onclick="location.href='${"/pokemon/" + pokemon.getPokedex()}';">
                    <td>${pokemon.getPokedex()}</td>
                    <td>${pokemon.getName()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>

</div>
</body>
</html>