import 'dart:convert';

class ModeloToken{
  String access_token;

  ModeloToken({this.access_token=""});
  factory ModeloToken.fromJson(Map<String, dynamic> map) {
    return ModeloToken(
      access_token: map["access_token"],
    );
  }
  Map<String, dynamic> toJson() {
    return {
      "access_token": access_token,
    };
  }
  @override
  String toString() {
    return 'ModeloToken{access_token: $access_token}';
  }
}



class ModeloUser {
  String username;
  String password;
  //String access_token;

  ModeloUser({this.username="", this.password=""/*,this.access_token=""*/});
  factory ModeloUser.fromJson(Map<String, dynamic> map) {
    return ModeloUser(
        username: map["username"],
        password: map["password"],
        //access_token: map["access_token"],
    );
  }
  Map<String, dynamic> toJson() {
    return {
      "username": username,
      "password": password,
      //"access_token": access_token,
    };
  }
  @override
  String toString() {
    return 'ModeloUser{username: $username, password: $password}';//access_token: $access_token
  }
}