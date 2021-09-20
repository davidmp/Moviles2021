import 'package:google_sign_in/google_sign_in.dart';

GoogleSignIn _googleSignIn = GoogleSignIn(scopes: ['email']);
String nombre;
String email;
String urlfoto;
Future<String> sinInwhitGoogle() async {
  try {
    await _googleSignIn.signIn();
  } catch (e) {
    print(e);
    //print("Error");
  }
  final GoogleSignInAccount user = _googleSignIn.currentUser;
  if (user != null) {
    nombre = user.displayName;
    print("Ingreso");
    email = user.email;
    urlfoto = user.photoUrl;
    return '$user';
  }
  return null;
}

Future<void> signOutGoogle() async {
  await _googleSignIn.signOut();
}
