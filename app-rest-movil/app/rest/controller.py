from flask.wrappers import Response
from flask import request, jsonify
import json
from app import app,mongo 
import datetime
from flask_jwt import jwt_required
from bson.objectid import ObjectId

@app.route("/api/persona")
def home_page():
    data = list(mongo.db.persona.find())
    #print(online_users)
    print("Holasss")
    return Response(
        response=json.dumps(data,default=str),
        status=200,
        mimetype="application/json"
    )    

@app.route("/crear",methods=["POST"])
@jwt_required()
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
    
@app.route("/api/persona/<string:id>", methods=["PATCH"])
def update(id):
    print(id)
    _json=request.json
    print("VER:",_json["nombre"])
    try:
        dbResponse = mongo.db.persona.update_one(
        {"_id": ObjectId(id)},
        {"$set": {"nombre": _json["nombre"]}}
        )
        if dbResponse.modified_count == 1:
            return Response(
            response=json.dumps({"message": "updated!!"}, default=str),
            status=200,
            mimetype="application/json"
            )
        return Response(
        response=json.dumps({"message": "Nothing to Update!!"}, default=str),
        status=200,
        mimetype="application/json"
        )
    except Exception as e:
        print(e)
        return Response(
        response=json.dumps({"message": "OOPS!! can't update"}, default=str),
        status=500,
        mimetype="application/json")

@app.route("/api/persona/<string:id>", methods=["DELETE"])
@jwt_required()
def delete(id):
    try:
        dbResponse = mongo.db.persona.delete_one({"_id": ObjectId(id)})
        if dbResponse.deleted_count == 1:
            return Response(
            response=json.dumps({"message": "Deleted!!", "id": f"{id}"}, default=str),
            status=200,
            mimetype="application/json"
            )
        return Response(
        response=json.dumps({"message": "Not Found!!", "id": f"{id}"}, default=str),
        status=404,
        mimetype="application/json"
        )
    except Exception as e:
        print(e)
        return Response(
        response=json.dumps({"message": "OOPS!! can't delete"}, default=str),
        status=500,
        mimetype="application/json"
        )