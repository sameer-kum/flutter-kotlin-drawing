# 🪄 Flutter & Kotlin Magic App

Hi! 👋 This is a special app where **Flutter** and **Kotlin** work together like best friends.

## 🤔 What is this?

Imagine you are building a Lego castle.
*   **Flutter** is the outside of the castle that everyone sees and touches.
*   **Kotlin** is the wizard inside who does the magic tricks.

In this project, Flutter (the screen) asks Kotlin (the wizard) to do things, and Kotlin does them!

## 🚀 What does it do?

1.  **Secret Message**: You click a button, and Flutter calls Kotlin. Kotlin replies: *"Hello from separate Kotlin class!"*
2.  **Cool Drawing**: You click "Import Your Design", and Kotlin draws a **Turbo Speedometer** 🏎️ from scratch and shows it right inside the Flutter app!

## 🛠️ What tools did we use?

*   **Flutter**: To make the buttons and the app screen.
*   **Kotlin**: To write the logic and draw the cool shapes.
*   **MethodChannel**: This is like a **telephone** 📞. Flutter picks it up to call Kotlin.
*   **PlatformView**: This is like a **picture frame** 🖼️. Flutter holds the frame, and Kotlin paints the picture inside it.

## 🎮 How to run it?

1.  Open this folder on your computer.
2.  Connect your Android phone.
3.  Type `flutter run` in the terminal.
4.  Tap the buttons and see the magic!

## 📂 Where is the code?

*   **The Screen (Flutter)**: `lib/main.dart`
*   **The Wizard (Kotlin)**: `android/app/src/main/kotlin/com/example/flutter_kotlin_drawing/`
    *   `NativeHandler.kt`: The brain that answers questions.
    *   `ComplexDrawingView.kt`: The artist that draws the speedometer.
