part of 'api_persona.dart';
class _PersonaApi implements PersonaApi {
  _PersonaApi(this._dio, {this.baseUrl}) {
    ArgumentError.checkNotNull(_dio, '_dio');
    this.baseUrl ??= "http://192.168.1.142:6060";
  }

  final Dio _dio;
  String baseUrl;

  @override
  getPersona() async {
    //final prefs= await SharedPreferences.getInstance();
    //var tokenx=prefs.getString("token");
    //print("VER: ${tokenx}");
    //ArgumentError.checkNotNull(tokenx, "token");
    const _extra = <String, dynamic>{};
    final queryParameters = <String, dynamic>{};
    final _data = <String, dynamic>{};
    final Response<List<dynamic>> _result = await _dio.request('/api/persona',
        queryParameters: queryParameters,
        options: RequestOptions(
            method: 'GET',
            headers: <String, dynamic>{ /*"Authorization":tokenx*/
            },
            extra: _extra,
            baseUrl: baseUrl
        ),
        data: _data);
    var value = _result.data
        .map((dynamic i) => ModeloPersona.fromJson(i as Map<String, dynamic>))
        .toList();
    return Future.value(value);
  }
}