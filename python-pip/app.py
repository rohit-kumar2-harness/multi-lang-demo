from flask import Flask, render_template_string

app = Flask(__name__)

HTML_CONTENT = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Python Flask Demo</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: linear-gradient(135deg, #fa709a 0%, #fee140 100%);
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
            background: #ffd93d;
            color: #6c4a00;
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
        <h1>🐍 Python Flask Demo</h1>
        <div class="badge">Pip Package Manager</div>
        <div class="info">
            <p><strong>Technology:</strong> Python with Flask</p>
            <p><strong>Package Manager:</strong> Pip</p>
            <p><strong>Port:</strong> 5000</p>
            <p><strong>Status:</strong> ✅ Running</p>
        </div>
        <p>This is a simple Python application using Flask web framework. It serves this HTML page with a beautiful gradient background.</p>
    </div>
</body>
</html>
"""

@app.route('/')
def home():
    return render_template_string(HTML_CONTENT)

if __name__ == '__main__':
    print('Python Flask server running at http://localhost:5000')
    app.run(host='0.0.0.0', port=5000, debug=True)
