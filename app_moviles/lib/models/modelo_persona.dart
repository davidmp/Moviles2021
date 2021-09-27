import 'dart:convert';

class ModeloPersona {
  String dni;
  String nombre;
  String telefono;
  int edad;
  String fecha_nac;

  ModeloPersona({this.dni="", this.nombre="",this.telefono="", this.edad, this.fecha_nac=""});
  factory ModeloPersona.fromJson(Map<String, dynamic> map) {
    return ModeloPersona(
        dni: map["dni"],
        nombre: map["nombre"],
        telefono: map["telefono"],
        edad: map["edad"],
        fecha_nac: map["fecha_nac"]
    );
  }
  Map<String, dynamic> toJson() {
    return {
      "dni": dni,
      "nombre": nombre,
      "telefono": telefono,
      "edad": edad,
      "fecha_nac": fecha_nac,
    };
  }
  @override
  String toString() {
    return 'ModeloPersona{dni: $dni, nombre: $nombre, telefono: $telefono, edad: $edad, fecha_nac: $fecha_nac}';
  }
}