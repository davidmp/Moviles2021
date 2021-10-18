import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:app_moviles/models/modelo_user.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:pretty_dio_logger/pretty_dio_logger.dart';
import 'package:retrofit/retrofit.dart';
import 'package:dio/dio.dart' hide Headers;
import 'dart:io';
import 'package:shared_preferences/shared_preferences.dart';

part 'api_persona.g.dart';

@RestApi(baseUrl: "http://192.168.1.143:6060")
abstract class PersonaApi {
  factory PersonaApi(Dio dio, {String baseUrl})=_PersonaApi;

  static PersonaApi create() {
    final dio = Dio();
    dio.interceptors.add(PrettyDioLogger());
    return PersonaApi(dio);
  }

  @GET("/api/persona")
  Future<List<ModeloPersona>> getPersona();

  @POST("/api/auth")
  Future<ModeloToken> login(@Body() ModeloUser usuario);

  @GET("/api/persona/{id}")
  Future<List<ModeloPersona>> getPersonaId(@Header("Authorization") String token, @Path("id") String id);

  @DELETE("/api/persona/{id}")
  Future<ModeloMsg> deletePersona(@Path("id") String id);

  @PATCH("/api/personaut/{id}")
  Future<ModeloMsg> updatePersona(@Path("id") String id, @Body() ModeloPersona persona);

  @POST("/api/persona/crear")
  Future<ModeloMsg> createPersona(@Body() ModeloPersona persona);

}