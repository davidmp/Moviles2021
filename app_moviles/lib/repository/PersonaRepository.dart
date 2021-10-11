import 'dart:async';
import 'package:app_moviles/apis/api_persona.dart';
import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:dio/dio.dart';
class PersonaRepository {
  PersonaApi personaApi;

  PersonaRepository() {
    Dio _dio = Dio();
    _dio.options.headers["Content-Type"] = "application/json";
    personaApi = PersonaApi(_dio);
  }

  Future<List<ModeloPersona>> getPersona() async {
    return await personaApi.getPersona();
  }

  Future<ModeloMsg> deletePersona(String id) async {
    return await personaApi.deletePersona(id);
  }

  Future<ModeloMsg> updatePersona(String id, ModeloPersona persona) async {
    return await personaApi.updatePersona(id, persona);
  }

  Future<ModeloMsg> createPersona(ModeloPersona persona) async {
    return await personaApi.createPersona(persona);
  }
}