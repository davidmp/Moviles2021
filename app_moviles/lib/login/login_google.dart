import 'package:app_moviles/drawer/navigation_home_screen.dart';
import 'package:flutter/material.dart';
import 'package:app_moviles/login/sing_in.dart';

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
            _singInButton(),
          ],
        ),
      ),
    );
  }

  Widget _singInButton() {
    return OutlinedButton(
      onPressed: () async {
        sinInwhitGoogle().then((result) {
          if (result != null) {
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
