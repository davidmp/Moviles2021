import 'package:app_moviles/apis/api_persona.dart';
import 'package:app_moviles/drawer/navigation_home_screen.dart';
import 'package:app_moviles/models/modelo_user.dart';
import 'package:flutter/material.dart';
import 'package:app_moviles/login/sing_in.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

class MainLogin extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Provider<PersonaApi>(
      create: (_)=>PersonaApi.create(),
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
            primaryColor: Colors.lightBlue
        ),
        home: LoginPage(),
      ),
    );
  }
}


class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.white,
        child: Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Image(
              image: AssetImage("assets/imagen/logo_upeu.png"),
            ),
            SizedBox(
              height: 20,
            ),
            _singInButton(context),
          ],
        ),
      ),
    );
  }

  Widget _singInButton(BuildContext context) {
    return OutlinedButton(
      onPressed: () async {
        var token;
        final prefs= await SharedPreferences.getInstance();
        sinInwhitGoogle().then((result) {
          print("Holasssssss $result");
          if (result != null) {
            final api=Provider.of<PersonaApi>(context, listen: false);
            final usuario=new ModeloUser();
             usuario.username="davidmp";
             usuario.password="Moviles12345";
              api.login(usuario).then((value) {
                //print("Probando!!!......"+value.access_token);
                token="JWT "+value.access_token;
                prefs.setString("token", token);
                print(token);
              }).catchError((onError){
                print(onError.toString());
              });

            Navigator.of(context).push(MaterialPageRoute(builder: (context) {
              return NavigationHomeScreen();
            }));
          } else {
            print("Errorssssssss");
          }
        });
      },
      child: Padding(
        padding: const EdgeInsets.fromLTRB(0, 10, 0, 10),
        child: Row(
          children: <Widget>[
            Image(image: AssetImage("assets/imagen/user-login-icon.png")),
            Padding(
              padding: const EdgeInsets.only(left: 10),
              child: Text("Ingresar"),
            ),
          ],
        ),
      ),
    );
  }
}
