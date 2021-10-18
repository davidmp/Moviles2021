import 'dart:convert';

class ModeloPersona {
  String id;
  String dni;
  String nombre;
  String telefono;
  int edad;
  String fecha_nac;
  String genero;

  ModeloPersona({this.id="",this.dni="", this.nombre="",this.telefono="", this.edad, this.fecha_nac="", this.genero});
  factory ModeloPersona.fromJson(Map<String, dynamic> map) {
    return ModeloPersona(
        id: map["_id"],
        dni: map["dni"],
        nombre: map["nombre"],
        telefono: map["telefono"],
        edad: map["edad"],
        fecha_nac: map["fecha_nac"],
        genero: map["genero"]
    );
  }

  Map<String, dynamic> toJson() {
    return {
      "dni": dni,
      "nombre": nombre,
      "telefono": telefono,
      "edad": edad,
      "fecha_nac": fecha_nac,
      "genero": genero,
    };
  }

  Map<String, dynamic> toMap() {
    var map = Map<String, dynamic>();
    map["dni"] = dni;
    map["nombre"] = nombre;
    map["telefono"] = telefono;
    map["edad"] = edad;
    map["fecha_nac"] = fecha_nac;
    map["genero"] = genero;
    if (id != null) {
      map["id"] = id;
    }
    return map;
  }

  ModeloPersona.fromObject(dynamic o) {
    this.id = o["id"].toString();
    this.dni = o["dni"];
    this.nombre = o["nombre"];
    this.telefono = o["telefono"];
    this.edad = int.tryParse(o["edad"].toString());
    this.fecha_nac = o["fecha_nac"];
    this.genero = o["genero"];

  }

  @override
  String toString() {
    return 'ModeloPersona{dni: $dni, nombre: $nombre, telefono: $telefono, edad: $edad, fecha_nac: $fecha_nac, genero: $genero}';
  }
}