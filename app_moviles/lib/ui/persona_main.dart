import 'package:app_moviles/apis/api_persona.dart';
import 'package:app_moviles/drawer/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:app_moviles/models/modelo_persona.dart';
import 'package:provider/provider.dart';
import 'package:intl/intl.dart';
class MainPersona extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Provider<PersonaApi>(
      create: (_)=>PersonaApi.create(),
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
            primaryColor: Colors.lightBlue
        ),
        home: PersonaUI(),
      ),
    );
  }
}
class PersonaUI extends StatefulWidget {
  @override
  _PersonaUIState createState() => _PersonaUIState();
}

class _PersonaUIState extends State<PersonaUI> {
//ApiCovid apiService;
  final DateFormat formatter = DateFormat('yyyy-MM-dd');
  var api;
  @override
  void initState() {
    super.initState();
//apiService = ApiCovid();
//api=Provider.of<PredictionApi>(context, listen: false).getPrediction();
    print("entro aqui");
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: Text(
          'Lista de Personas',
        ),
        automaticallyImplyLeading: false,
        centerTitle: true,
      ),
      backgroundColor: AppTheme.nearlyWhite,
      body: FutureBuilder<List<ModeloPersona>>(
        future: Provider.of<PersonaApi>(context, listen: true).getPersona(),
        builder: (BuildContext context,
            AsyncSnapshot<List<ModeloPersona>> snapshot) {
          if (snapshot.hasError) {
            return Center(
              child: Text(
                  "Something wrong with message: ${snapshot.error.toString()}"),
            );
          } else if (snapshot.connectionState == ConnectionState.done) {
            List<ModeloPersona> persona = snapshot.data;
            print(persona.length);
            return _buildListView(persona);
          } else {
            return Center(
              child: CircularProgressIndicator(),
            );
          }
        },
      ),
    );
  }


  Widget _buildListView(List<ModeloPersona> persona) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 16.0),
      child: ListView.builder(
        itemBuilder: (context, index) {
          ModeloPersona personax = persona[index];
          return Padding(
            padding: const EdgeInsets.only(top: 8.0),
            child: Card(
              child: Padding(
                padding: const EdgeInsets.all(10.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    ListTile(
                        title: Text(personax.nombre,
                            style: Theme.of(context).textTheme.headline6),
                        subtitle: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceAround,
                            children: <Widget>[
                              Container(
                                decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(8),
                                    color: Colors.redAccent),
                                child: Text(
                                  personax.dni,
                                  style: TextStyle(
                                      color: Colors.black, fontSize: 16),
                                ),
                              ),
                              Container(
                                decoration: BoxDecoration(
                                    borderRadius: BorderRadius.circular(8),
                                    color: Colors.yellow),
                                child: Text(
                                  personax.edad.toString(),
                                  style: TextStyle(
                                      color: Colors.black, fontSize: 16),
                                ),
                              ),

                            ]),
                        leading: CircleAvatar(
                          backgroundImage:
                          AssetImage("assets/imagen/man-icon.png"),
                        ),
                        trailing: Icon(Icons.star)),
                  ],
                ),
              ),
            ),
          );
        },
        itemCount: persona.length,
      ),
    );
  }

}

