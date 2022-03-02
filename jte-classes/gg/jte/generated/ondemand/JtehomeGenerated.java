package gg.jte.generated.ondemand;
import app.models.Pk;
import java.util.List;
public final class JtehomeGenerated {
	public static final String JTE_NAME = "home.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,66,66,66,67,68,68,68,69,69,69,69,69,69,69,70,70,70,72,72,79};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Pk> pokemons) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css\">\r\n    <style>\r\n        th, td {\r\n            text-align: center;\r\n            vertical-align: middle;\r\n        }\r\n\r\n        td {\r\n            font-weight: bold;\r\n        }\r\n\r\n        .centerChildren {\r\n            display: flex;\r\n            flex-direction: column;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding: 5% 0;\r\n        }\r\n\r\n        .verticalSpacing {\r\n            margin: 5% auto;\r\n        }\r\n\r\n        .clickable:hover {\r\n            cursor: pointer;\r\n            background-color: #41adff;\r\n        }\r\n\r\n        button:hover{\r\n            background-color: #41adff;\r\n        }\r\n    </style>\r\n</head>\r\n\r\n<body>\r\n<div class=\"centerChildren\">\r\n    <h1>Welcome to Your PokeDex!</h1>\r\n\r\n    <div class=\"verticalSpacing\">\r\n        <img src=\"https://upload.wikimedia.org/wikipedia/commons/b/b1/Pok%C3%A9ball.png\" height=\"100\" width=\"100\">\r\n    </div>\r\n\r\n    <div class=\"centerChildren\">\r\n        <h3>Enter Pokemon name</h3>\r\n        <form method=\"post\" action=\"/pokemon\" class=\"centerChildren\">\r\n            <input type=\"text\" name=\"name\" required>\r\n            <button type=\"submit\">search</button>\r\n        </form>\r\n    </div>\r\n\r\n    <div class=\"verticalSpacing\">\r\n        <table>\r\n            <thead>\r\n            <tr>\r\n                <th>Sprite</th>\r\n                <th>Name</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            ");
		for (Pk pokemon: pokemons) {
			jteOutput.writeContent("\r\n                ");
			jteOutput.writeContent("\r\n                <tr class=\"clickable\" onclick=\"location.href='");
			jteOutput.setContext("tr", "onclick");
			jteOutput.writeUserContent("/pokemon/" + pokemon.getPokedex());
			jteOutput.writeContent("';\">\r\n                    <td><img");
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(pokemon.getImageURL().toString())) {
				jteOutput.writeContent(" src=\"");
				jteOutput.setContext("img", "src");
				jteOutput.writeUserContent(pokemon.getImageURL().toString());
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent("></td>\r\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(pokemon.getName());
			jteOutput.writeContent("</td>\r\n                </tr>\r\n            ");
		}
		jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n    </div>\r\n\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Pk> pokemons = (List<Pk>)params.get("pokemons");
		render(jteOutput, jteHtmlInterceptor, pokemons);
	}
}
