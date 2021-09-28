import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';
import 'package:syncfusion_flutter_charts/sparkcharts.dart';

void main() {
  return runApp(_ChartApp());
}

class _ChartApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.blue),
      home: _MyHomePage(),
    );
  }
}

class _MyHomePage extends StatefulWidget {
  // ignore: prefer_const_constructors_in_immutables
  _MyHomePage({Key? key}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<_MyHomePage> {
  List<_SalesData> data = [
    _SalesData('Jan', 35,50),
    _SalesData('Feb', 28,51),
    _SalesData('Mar', 34,56),
    _SalesData('Apr', 32,58),
    _SalesData('May', 40,60),
    _SalesData('Jun', 40,61),
    _SalesData('Jul', 60,63),
    _SalesData('Oug', 70,80)


  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Syncfusion Flutter chart'),
        ),
        body: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
          //Initialize the chart widget
          SfCartesianChart(

              primaryXAxis: CategoryAxis(),
              // Chart title
              title: ChartTitle(text: 'Half yearly sales analysis'),
              // Enable legend
              legend: Legend(isVisible: true),
              // Enable tooltip
              tooltipBehavior: TooltipBehavior(enable: true),
              series: <ChartSeries<_SalesData, String>>[
                LineSeries<_SalesData, String>(
                    dataSource: data,
                    xValueMapper: (_SalesData sales, _) => sales.year,
                    yValueMapper: (_SalesData sales, _) => sales.sales,
                    //yValueMapper: (_SalesData sales, _)=> sales.predict,
                    name: 'Sales',
                    // Enable data label
                    dataLabelSettings: DataLabelSettings(isVisible: true)),
                    LineSeries<_SalesData, String>(
                        dataSource: data,
                        xValueMapper: (_SalesData sales, _) => sales.year,
                        yValueMapper: (_SalesData sales, _) => sales.predict,
                        //yValueMapper: (_SalesData sales, _)=> sales.predict,
                        name: 'predict',
                        // Enable data label
                        dataLabelSettings: DataLabelSettings(isVisible: true))
              ]),

        ]));
  }
}

class _SalesData {
  _SalesData(this.year, this.sales, this.predict);

  String year;
  double sales;
  double predict;
}