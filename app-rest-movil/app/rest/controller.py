from flask.wrappers import Response
import json
from app import app,mongo 
@app.route("/pru")
def home_page():
    data = list(mongo.db.user.find())
    #print(online_users)
    print("Holasss")
    return Response(
        response=json.dumps(data,default=str),
        status=200,
        mimetype="application/json"
    )
    #return render_template("index.html",
    #    online_users=online_users)