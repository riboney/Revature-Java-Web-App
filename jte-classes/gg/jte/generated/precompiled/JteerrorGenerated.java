package gg.jte.generated.precompiled;
public final class JteerrorGenerated {
	public static final String JTE_NAME = "error.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,23,23,23,23,27};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String error) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n<head>\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css\">\r\n    <style>\r\n        .centerChildren {\r\n            display: flex;\r\n            flex-direction: column;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding-top: 5% 0;\r\n        }\r\n    </style>\r\n</head>\r\n\r\n<body>\r\n    <div class=\"centerChildren\">\r\n        <h1>Uh oh, error!</h1>\r\n        <div>\r\n            <img src=\"https://i.kym-cdn.com/photos/images/original/001/431/201/40f.png\" height=\"100\" width=\"100\">\r\n        </div>\r\n        <h3>");
		jteOutput.setContext("h3", null);
		jteOutput.writeUserContent(error);
		jteOutput.writeContent("</h3>\r\n        <button onclick=\"location.href='/';\" >Back</button>\r\n    </div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String error = (String)params.get("error");
		render(jteOutput, jteHtmlInterceptor, error);
	}
}
