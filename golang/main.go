package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

const htmlContent = `
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Golang Demo</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
            color: white;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
        }
        h1 {
            margin-top: 0;
            font-size: 2.5em;
        }
        .badge {
            display: inline-block;
            background: #38f9d7;
            color: #004d40;
            padding: 5px 15px;
            border-radius: 20px;
            font-weight: bold;
            margin: 10px 0;
        }
        .info {
            margin: 20px 0;
            line-height: 1.8;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🐹 Golang Demo</h1>
        <div class="badge">Go Modules</div>
        <div class="info">
            <p><strong>Technology:</strong> Go with Gorilla Mux</p>
            <p><strong>Package Manager:</strong> Go Modules</p>
            <p><strong>Port:</strong> 9000</p>
            <p><strong>Status:</strong> ✅ Running</p>
        </div>
        <p>This is a simple Go application using Gorilla Mux router. It serves this HTML page with high performance and concurrency.</p>
    </div>
</body>
</html>
`

func homeHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/html")
	fmt.Fprint(w, htmlContent)
}

func main() {
	r := mux.NewRouter()
	r.HandleFunc("/", homeHandler)

	fmt.Println("Golang server running at http://localhost:9000")
	log.Fatal(http.ListenAndServe(":9000", r))
}
