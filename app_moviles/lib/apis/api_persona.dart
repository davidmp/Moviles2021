import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:pretty_dio_logger/pretty_dio_logger.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;
import 'dart:io';
import 'package:shared_preferences/shared_preferences.dart';

part 'api_persona.g.dart';

@RestApi(baseUrl: "http://192.168.1.142:6060")
abstract class PersonaApi {
  factory PersonaApi(Dio dio, {String baseUrl})=_PersonaApi;

  static PersonaApi create() {
    final dio = Dio();
    dio.interceptors.add(PrettyDioLogger());
    return PersonaApi(dio);
  }

  @GET("/api/persona")
  Future<List<ModeloPersona>> getPersona();

  /*@GET("/api/estadis")
  Future<List<ModeloPersona>> getPredictionChart();

  @GET("/api/cov/{cantidad}")
  Future<List<ModeloPersona>> getPredictionCant(@Path("cantidad") int cantidad);*/

}