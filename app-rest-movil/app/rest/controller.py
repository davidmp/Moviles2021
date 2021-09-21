from flask.wrappers import Response
from flask import request, jsonify
import json
from app import app,mongo 
import datetime
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

@app.route("/crear",methods=["POST"])
def crear():
    try:
        _json=request.json
        data_format=datetime.datetime.strptime(_json["fecha_nac"],'%Y-%m-%d')
        _json["fecha_nac"]=data_format
        dbResponse=mongo.db.persona.insert_one(_json)
        print(dbResponse.inserted_id)
        return Response(
            response=json.dumps(
                {
                    "mesage":"Se creo correctamente"
                }, default=str
            ),
            status=200,
            mimetype="application/json"
        )
    except Exception as e:
        print(e)
        return Response(
            response=json.dumps(
                {
                    "mesage":"Error al crear registro"
                }, default=str
            ),
            status=200,
            mimetype="application/json"
        )
    