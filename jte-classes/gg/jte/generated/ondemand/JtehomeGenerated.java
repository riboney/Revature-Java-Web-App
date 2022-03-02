package gg.jte.generated.ondemand;
import app.models.Pk;
import app.utils.PkType;
import java.util.List;
public final class JtehomeGenerated {
	public static final String JTE_NAME = "home.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,53,53,58,63,73,80,82,90,113,116,122,122,123,123,124,124,124,124,124,124,124,125,125,125,127,127,128,128,142,142,143,144,144,144,145,145,145,145,145,145,145,146,146,146,148,148,155};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Pk> pokemons) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css\">\r\n    <style>\r\n\r\n        .centerChildren {\r\n            display: flex;\r\n            flex-direction: column;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding-top: 5% 0;\r\n        }\r\n\r\n        h1 {\r\n            text-align: center;\r\n        }\r\n\r\n        th, td {\r\n            text-align: center;\r\n            vertical-align: middle;\r\n        }\r\n\r\n        td {\r\n            font-weight: bold;\r\n        }\r\n\r\n        .verticalSpacing {\r\n            margin-top: 5%;\r\n        }\r\n\r\n        .clickable:hover {\r\n            cursor: pointer;\r\n            background-color: #41adff;\r\n        }\r\n\r\n        button:hover{\r\n            background-color: #41adff;\r\n        }\r\n\r\n        select {\r\n            margin: auto;\r\n        }\r\n\r\n        option {\r\n            text-align: center;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        @media\r\n        only screen and (max-width: 760px),\r\n        (min-device-width: 768px) and (max-device-width: 1024px)  {\r\n\r\n            ");
		jteOutput.writeContent("\r\n            table, thead, tbody, th, td, tr {\r\n                display: block;\r\n            }\r\n\r\n            ");
		jteOutput.writeContent("\r\n            thead tr {\r\n                position: absolute;\r\n                top: -9999px;\r\n                left: -9999px;\r\n            }\r\n\r\n            tr { border: 1px solid #ccc; }\r\n\r\n            td {\r\n                ");
		jteOutput.writeContent("\r\n                border: none;\r\n                position: relative;\r\n                padding-left: 10em;\r\n            }\r\n\r\n            td:before {\r\n                ");
		jteOutput.writeContent("\r\n                position: absolute;\r\n                ");
		jteOutput.writeContent("\r\n                top: 6px;\r\n                left: 6px;\r\n                width: 45%;\r\n                padding-right: 2em;\r\n                white-space: nowrap;\r\n            }\r\n\r\n            ");
		jteOutput.writeContent("\r\n            td:nth-of-type(1):before { content: \"Sprite\"; }\r\n            td:nth-of-type(2):before { content: \"Name\"; }\r\n        }\r\n    </style>\r\n</head>\r\n\r\n<body>\r\n<div class=\"centerChildren\">\r\n    <h1>Welcome to the PokeDex!</h1>\r\n\r\n    <div class=\"verticalSpacing\">\r\n        <img src=\"https://upload.wikimedia.org/wikipedia/commons/b/b1/Pok%C3%A9ball.png\" height=\"100\" width=\"100\">\r\n    </div>\r\n\r\n    <div class=\"centerChildren\">\r\n        <h3>Enter Pokemon name</h3>\r\n        <form method=\"post\" action=\"/pokemon\" class=\"centerChildren\">\r\n            <input type=\"text\" name=\"name\" required>\r\n            <button type=\"submit\">search</button>\r\n        </form>\r\n        ");
		jteOutput.writeContent("\r\n        <form id=\"typeForm\" method=\"post\" action=\"/\">\r\n            <h3>Filter Pokemons by Type</h3>\r\n            ");
		jteOutput.writeContent("\r\n            <select name=\"type\" id=\"type-select\" onchange=\"this.form.submit()\">\r\n                <option name=\"type\">Select type</option>\r\n                <option name=\"type\" value=\"all\">\r\n                    all\r\n                </option>\r\n                ");
		for (PkType type: PkType.values()) {
			jteOutput.writeContent("\r\n                    ");
			if (!type.toString().equalsIgnoreCase("none")) {
				jteOutput.writeContent("\r\n                        <option name=\"type\"");
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(type.toString())) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("option", "value");
					jteOutput.writeUserContent(type.toString());
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n                            ");
				jteOutput.setContext("option", null);
				jteOutput.writeUserContent(type.toString().toLowerCase());
				jteOutput.writeContent("\r\n                        </option>\r\n                    ");
			}
			jteOutput.writeContent("\r\n                ");
		}
		jteOutput.writeContent("\r\n            </select>\r\n        </form>\r\n    </div>\r\n\r\n    <div class=\"verticalSpacing\">\r\n        <table>\r\n            <thead>\r\n            <tr>\r\n                <th>Sprite</th>\r\n                <th>Name</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            ");
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
