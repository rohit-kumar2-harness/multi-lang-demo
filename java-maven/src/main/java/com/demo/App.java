package com.demo;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);
        
        staticFiles.location("/public");
        
        get("/", (req, res) -> {
            res.type("text/html");
            return getHtmlContent();
        });
        
        System.out.println("Java Maven server running at http://localhost:8080");
    }
    
    private static String getHtmlContent() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Java Maven Demo</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            max-width: 800px;\n" +
                "            margin: 50px auto;\n" +
                "            padding: 20px;\n" +
                "            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);\n" +
                "            color: white;\n" +
                "        }\n" +
                "        .container {\n" +
                "            background: rgba(255, 255, 255, 0.1);\n" +
                "            backdrop-filter: blur(10px);\n" +
                "            border-radius: 15px;\n" +
                "            padding: 40px;\n" +
                "            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);\n" +
                "        }\n" +
                "        h1 {\n" +
                "            margin-top: 0;\n" +
                "            font-size: 2.5em;\n" +
                "        }\n" +
                "        .badge {\n" +
                "            display: inline-block;\n" +
                "            background: #ff6b9d;\n" +
                "            color: #4a0e1f;\n" +
                "            padding: 5px 15px;\n" +
                "            border-radius: 20px;\n" +
                "            font-weight: bold;\n" +
                "            margin: 10px 0;\n" +
                "        }\n" +
                "        .info {\n" +
                "            margin: 20px 0;\n" +
                "            line-height: 1.8;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>☕ Java Maven Demo</h1>\n" +
                "        <div class=\"badge\">Maven Build Tool</div>\n" +
                "        <div class=\"info\">\n" +
                "            <p><strong>Technology:</strong> Java with Spark Framework</p>\n" +
                "            <p><strong>Build Tool:</strong> Maven</p>\n" +
                "            <p><strong>Port:</strong> 8080</p>\n" +
                "            <p><strong>Status:</strong> ✅ Running</p>\n" +
                "        </div>\n" +
                "        <p>This is a simple Java application using Maven as the build tool. It serves this HTML page using Spark micro-framework.</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
