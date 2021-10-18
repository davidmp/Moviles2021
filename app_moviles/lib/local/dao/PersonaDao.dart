import 'package:app_moviles/local/db/db_creation.dart';
import 'package:app_moviles/models/modelo_msg.dart';
import 'package:app_moviles/models/modelo_persona.dart';

class PersonaDaoLocate extends BaseRepository{


  Future<List<ModeloPersona>> getAllPersona() async {
    final db = await database;
// var result = await db.query('msProduct');
    var result = await db.rawQuery('SELECT * FROM persona');
    List<ModeloPersona> listProduct = result.isNotEmpty ? result.map((c) => ModeloPersona.fromObject(c)).toList() : [];
    return listProduct;
  }

  Future<ModeloMsg> insertPersona(ModeloPersona persona) async{
    final db = await database;
    var result = await db.rawInsert('INSERT INTO persona(dni, nombre, telefono, edad, fecha_nac, genero) VALUES (?,?,?,?,?,?)',
        [persona.dni, persona.nombre, persona.telefono, persona.edad, persona.fecha_nac, persona.genero]);
    Map<String, dynamic> resultado = {'mensaje':"Se creo correctamente"};
    if(result==1){
      return Future.value(ModeloMsg.fromJson(resultado));
    }
    resultado["mensaje"]="No se pudo Registrar";
    return Future.value(ModeloMsg.fromJson(resultado));
  }

  Future<ModeloMsg> updatePersona(ModeloPersona product) async {
    final db = await database;
    int result = await db.update('persona', product.toMap(), where: 'id = ${product.id}');
    Map<String, dynamic> resultado = {'mensaje':"updated!!"};
    if(result==1){
      return Future.value(ModeloMsg.fromJson(resultado));
    }
    resultado["mensaje"]="No se pudo modificar los datos";
    return Future.value(ModeloMsg.fromJson(resultado));
  }

  Future<ModeloMsg> deletePersona(int id) async {
    final db = await database;
    var res=await db.delete('persona', where: 'id = $id');
    Map<String, dynamic> resultado = {'mensaje':"Deleted!!", 'id': id};
    if(res==1){
      return Future.value(ModeloMsg.fromJson(resultado));
    }
    resultado["mensaje"]="Error al eliminar";
    return Future.value(ModeloMsg.fromJson(resultado));
  }

  Future<int> deleteAll() async {
    final db = await database;
    return await db.delete('persona');
  }

}