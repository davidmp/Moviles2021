

class ModeloMsg{
  String mensaje;

  ModeloMsg({ this.mensaje});

  factory ModeloMsg.fromJson(Map<String, dynamic> json)=>ModeloMsg(mensaje: json["mensaje"]);

  Map<String, dynamic> toJson(){
    final Map<String, dynamic> data=new Map<String, dynamic>();
    data["mensaje"]=this.mensaje;
    return data;
  }

}