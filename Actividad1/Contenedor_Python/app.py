from flask import Flask
import datetime

app = Flask(__name__)

@app.route("/")
def get_time():
    now = datetime.datetime.now()
    return f"Current time is: {now}"

if __name__ == "__main__":
    # Escuchar en todas las interfaces, puerto 2000 (puedes mapearlo a otro en el host)
    app.run(host="0.0.0.0", port=2000)