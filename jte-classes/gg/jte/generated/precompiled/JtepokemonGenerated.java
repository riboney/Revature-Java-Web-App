package gg.jte.generated.precompiled;
import app.models.Pk;
public final class JtepokemonGenerated {
	public static final String JTE_NAME = "pokemon.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,38,38,43,48,58,66,68,76,94,94,94,112,112,112,112,112,112,112,113,113,113,114,114,114,115,115,115,116,116,116,117,117,117,118,118,118,119,119,119,127};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, app.models.Pk pokemon) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css\">\r\n    <style>\r\n\r\n        table {\r\n            table-layout: auto;\r\n        }\r\n\r\n        th, td {\r\n            text-align: center;\r\n            vertical-align: middle;\r\n            width: 10em;\r\n        }\r\n\r\n        td {\r\n            font-weight: bold;\r\n        }\r\n\r\n        .centerChildren {\r\n            display: flex;\r\n            flex-direction: column;\r\n            align-items: center;\r\n            justify-content: center;\r\n        }\r\n\r\n        .childrenBody {\r\n            margin: 10% auto;\r\n        }\r\n\r\n        button:hover{\r\n            background-color: #41adff;\r\n        }\r\n\r\n        ");
		jteOutput.writeContent("\r\n        @media\r\n        only screen and (max-width: 760px),\r\n        (min-device-width: 768px) and (max-device-width: 1024px)  {\r\n\r\n            ");
		jteOutput.writeContent("\r\n            table, thead, tbody, th, td, tr {\r\n                display: block;\r\n            }\r\n\r\n            ");
		jteOutput.writeContent("\r\n            thead tr {\r\n                position: absolute;\r\n                top: -9999px;\r\n                left: -9999px;\r\n            }\r\n\r\n            tr { border: 1px solid #ccc; }\r\n\r\n            td {\r\n                ");
		jteOutput.writeContent("\r\n                border: none;\r\n                border-bottom: 1px solid #eee;\r\n                position: relative;\r\n                padding-left: 10em;\r\n            }\r\n\r\n            td:before {\r\n                ");
		jteOutput.writeContent("\r\n                position: absolute;\r\n                ");
		jteOutput.writeContent("\r\n                top: 6px;\r\n                left: 8px;\r\n                width: 45%;\r\n                padding-right: 10px;\r\n                white-space: nowrap;\r\n            }\r\n\r\n            ");
		jteOutput.writeContent("\r\n            td:nth-of-type(1):before { content: \"Sprite\"; }\r\n            td:nth-of-type(2):before { content: \"Pokedex\"; }\r\n            td:nth-of-type(3):before { content: \"Name\"; }\r\n            td:nth-of-type(4):before { content: \"Type1\"; }\r\n            td:nth-of-type(5):before { content: \"Type2\"; }\r\n            td:nth-of-type(6):before { content: \"HP\"; }\r\n            td:nth-of-type(7):before { content: \"Attack\"; }\r\n            td:nth-of-type(8):before { content: \"Defense\"; }\r\n\r\n        }\r\n    </style>\r\n</head>\r\n\r\n<body>\r\n    <div class=\"centerChildren\">\r\n        <h2>");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(pokemon.getName());
		jteOutput.writeContent("</h2>\r\n\r\n        <div class=\"childrenBody\">\r\n            <table>\r\n                <thead>\r\n                <tr>\r\n                    <th>Sprite</th>\r\n                    <th>Pokedex</th>\r\n                    <th>Name</th>\r\n                    <th>Type1</th>\r\n                    <th>Type2</th>\r\n                    <th>HP</th>\r\n                    <th>Attack</th>\r\n                    <th>Defense</th>\r\n                </tr>\r\n                </thead>\r\n                <tbody>\r\n                <tr>\r\n                    <td><img");
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(pokemon.getImageURL().toString())) {
			jteOutput.writeContent(" src=\"");
			jteOutput.setContext("img", "src");
			jteOutput.writeUserContent(pokemon.getImageURL().toString());
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("></td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(Integer.toString(pokemon.getPokedex()));
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(pokemon.getName());
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(pokemon.getType1().toString());
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(pokemon.getType2().toString());
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(Integer.toString(pokemon.getHp()));
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(Integer.toString(pokemon.getAttack()));
		jteOutput.writeContent("</td>\r\n                    <td>");
		jteOutput.setContext("td", null);
		jteOutput.writeUserContent(Integer.toString(pokemon.getDefense()));
		jteOutput.writeContent("</td>\r\n                </tr>\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        <button onclick=\"location.href='/';\" >Back</button>\r\n    </div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		app.models.Pk pokemon = (app.models.Pk)params.get("pokemon");
		render(jteOutput, jteHtmlInterceptor, pokemon);
	}
}
