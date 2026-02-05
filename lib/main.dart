import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Kotlin Drawing',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Kotlin Task'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = MethodChannel('com.example.flutter_kotlin_drawing/drawing');
  String _nativeMessage = 'No message yet';
  bool _showNativeDesign = false;

  Future<void> _getNativeMessage() async {
    String message;
    try {
      final String result = await platform.invokeMethod('getNativeMessage');
      message = 'Native says: $result';
    } on PlatformException catch (e) {
      message = "Failed to get message: '${e.message}'.";
    }

    setState(() {
      _nativeMessage = message;
    });
  }

  void _importDesign() {
    setState(() {
      _showNativeDesign = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              const Text(
                'Message from Kotlin:',
              ),
              Text(
                _nativeMessage,
                style: Theme.of(context).textTheme.headlineMedium,
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _getNativeMessage,
                child: const Text('Call Native Function'),
              ),
              const SizedBox(height: 40),
              ElevatedButton(
                onPressed: _importDesign,
                child: const Text('Import Your Design'),
              ),
              if (_showNativeDesign) ...[
                const SizedBox(height: 20),
                const Text(
                  'Here is your native design',
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
                ),
                const SizedBox(height: 20),
                Container(
                  height: 300,
                  width: 300,
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.grey),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: const AndroidView(
                    viewType: 'complex-drawing-view',
                    creationParams: <String, dynamic>{},
                    creationParamsCodec: StandardMessageCodec(),
                  ),
                ),
              ],
            ],
          ),
        ),
      ),
    );
  }
}

