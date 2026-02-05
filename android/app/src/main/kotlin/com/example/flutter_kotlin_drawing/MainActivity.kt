package com.example.flutter_kotlin_drawing

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example.flutter_kotlin_drawing/drawing"
    private val nativeHandler = NativeHandler()

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        
        // Register the Platform View Factory
        flutterEngine
            .platformViewsController
            .registry
            .registerViewFactory("complex-drawing-view", ComplexViewFactory())

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getNativeMessage") {
                val message = nativeHandler.getNativeMessage()
                result.success(message)
            } else {
                result.notImplemented()
            }
        }
    }
}
