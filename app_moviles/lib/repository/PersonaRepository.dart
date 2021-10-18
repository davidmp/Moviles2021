import 'dart:async';
import 'package:app_moviles/apis/api_persona.dart';
import 'package:app_moviles/local/dao/PersonaDao.dart';
import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:app_moviles/util/NetworCon.dart';
import 'package:data_connection_checker/data_connection_checker.dart';
import 'package:dio/dio.dart';
class PersonaRepository {
  PersonaApi personaApi;
  PersonaDaoLocate personaLocal;
  PersonaRepository() {
    Dio _dio = Dio();
    _dio.options.headers["Content-Type"] = "application/json";
    personaApi = PersonaApi(_dio);
    personaLocal = PersonaDaoLocate();
  }

  Future<List<ModeloPersona>> getPersona() async {
      if(await isConected()) {
        return await personaApi.getPersona();
        //return await personaLocal.getAllPersona();
      } else {
        print('No internet :( Reason:');
        print(DataConnectionChecker().lastTryResults);
        return await personaLocal.getAllPersona();
      }
  }

  Future<ModeloMsg> deletePersona(String id) async {
    if(await isConected()) {
      return await personaApi.deletePersona(id);
      print("Verrr: ${id}");
      //return await personaLocal.deletePersona(int.parse(id));
    } else {
      print('No internet :( Reason:');
      print(DataConnectionChecker().lastTryResults);
      return await personaLocal.deletePersona(int.parse(id));
    }
  }

  Future<ModeloMsg> updatePersona(String id, ModeloPersona persona) async {
    if(await isConected()) {
      print("Verrr: ${id}");
      //return await personaLocal.updatePersona(persona);
      return await personaApi.updatePersona(id, persona);
    } else {
      print('No internet :( Reason:');
      print(DataConnectionChecker().lastTryResults);
      return await personaLocal.updatePersona(persona);
    }
  }

  Future<ModeloMsg> createPersona(ModeloPersona persona) async {
    if(await isConected()) {
      return await personaApi.createPersona(persona);
      //return await personaLocal.insertPersona(persona);
    } else {
      print('No internet :( Reason:');
      print(DataConnectionChecker().lastTryResults);
      return await personaLocal.insertPersona(persona);
    }
  }
}