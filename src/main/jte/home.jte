@import app.models.Pk
@import app.utils.PkType
@import java.util.List
@param List<Pk> pokemons

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
            padding: 5% 0;
        }

        .verticalSpacing {
            margin: 5% auto;
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
    </style>
</head>

<body>
<div class="centerChildren">
    <h1>Welcome to Your PokeDex!</h1>

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

    <div class="verticalSpacing">
        <table>
            <thead>
            <tr>
                <th>Sprite</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            @for(Pk pokemon: pokemons)
                <%--https://stackoverflow.com/a/17147876--%>
                <tr class="clickable" onclick="location.href='${"/pokemon/" + pokemon.getPokedex()}';">
                    <td><img src="${pokemon.getImageURL().toString()}"></td>
                    <td>${pokemon.getName()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>

</div>
</body>
</html>