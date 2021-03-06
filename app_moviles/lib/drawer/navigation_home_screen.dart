import 'package:app_moviles/drawer/app_theme.dart';
import 'package:app_moviles/drawer/drawer_user_controller.dart';
import 'package:app_moviles/drawer/home_drawer.dart';
//import 'package:covidapp/drawer/feedback_screen.dart';
import 'package:app_moviles/ui/help_screen.dart';
import 'package:app_moviles/ui/persona/persona_main.dart';
import 'package:app_moviles/ui/personab/personab_main.dart';
import 'package:app_moviles/ui/personafire/personab_main.dart';

//import 'package:covidapp/drawer/home_screen.dart';
//import 'package:covidapp/drawer/invite_friend_screen.dart';
import 'package:flutter/material.dart';

class NavigationHomeScreen extends StatefulWidget {
  @override
  _NavigationHomeScreenState createState() => _NavigationHomeScreenState();
}

class _NavigationHomeScreenState extends State<NavigationHomeScreen> {
  Widget screenView;
  DrawerIndex drawerIndex;

  @override
  void initState() {
    //drawerIndex = DrawerIndex.HOME;
    //screenView = HelpScreenD();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: AppTheme.nearlyWhite,
      child: SafeArea(
        top: false,
        bottom: false,
        child: Scaffold(
          backgroundColor: AppTheme.nearlyWhite,
          body: DrawerUserController(
            screenIndex: drawerIndex,
            drawerWidth: MediaQuery.of(context).size.width * 0.75,
            onDrawerCall: (DrawerIndex drawerIndexdata) {
              changeIndex(drawerIndexdata);
              //callback from drawer for replace screen as user need with passing DrawerIndex(Enum index)
            },
            screenView: screenView,
            //we replace screen view as we need on navigate starting screens like MyHomePage, HelpScreen, FeedbackScreen, etc...
          ),
        ),
      ),
    );
  }

  void changeIndex(DrawerIndex drawerIndexdata) {
    if (drawerIndex != drawerIndexdata) {
      drawerIndex = drawerIndexdata;
      if (drawerIndex == DrawerIndex.HOME) {
        setState(() {
          screenView = MainPersona();
        });
      } else if (drawerIndex == DrawerIndex.Help) {
        setState(() {
          screenView = MainPersonaB();
        });
      } else if (drawerIndex == DrawerIndex.FeedBack) {
        setState(() {
          screenView = MainPersonaBF();
        });
      } else if (drawerIndex == DrawerIndex.Invite) {
        setState(() {
          //screenView = HelpScreen();
        });
      } else {
        //do in your way......
      }
    }
  }
}
