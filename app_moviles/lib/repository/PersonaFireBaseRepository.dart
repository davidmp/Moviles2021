import 'dart:async';

import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:app_moviles/util/NetworCon.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class PersonaFireBaseRepository {

  CollectionReference db=FirebaseFirestore.instance.collection("persona");

  Future<List<ModeloPersona>> getPersona() async {
    if(await isConected()) {
      var data=await db.get();
      var persona=data.docs.map((e) => ModeloPersona.fromJson(e.data())).toList();
      return persona;
    } else {
      print('No internet');
    }
  }

  Future<void> createPersona(ModeloPersona persona) async {
    if(await isConected()) {
      return await db.add(persona.toMap())
          .then((value) =>print("El id es : ${value.id}"))
          .catchError((onError)=>print("Error $onError"));
    } else {
      print('No internet');
    }
  }

  Future<ModeloMsg> deletePersona(String id) async {
    /*if(await isConected()) {
      return await personaApi.deletePersona(id);
      print("Verrr: ${id}");
      //return await personaLocal.deletePersona(int.parse(id));
    } else {
      print('No internet');
    }*/
  }

  Future<ModeloMsg> updatePersona(String id, ModeloPersona persona) async {
    /*if(await isConected()) {
      print("Verrr: ${id}");
      //return await personaLocal.updatePersona(persona);
      return await personaApi.updatePersona(id, persona);
    } else {
      print('No internet');
    }*/
  }


}