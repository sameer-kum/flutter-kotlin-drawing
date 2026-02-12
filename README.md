# 🪄 Flutter & Kotlin Magic App

Hi! 👋 This is a special app where **Flutter** and **Kotlin** work together like best friends. This project demonstrates how to combine the cross-platform power of Flutter with the native capabilities of Android (Kotlin).

## 🤔 What is this?

Imagine you are building a Lego castle.
*   **Flutter** is the outside of the castle that everyone sees and touches.
*   **Kotlin** is the wizard inside who does the magic tricks.

In this project, Flutter (the screen) asks Kotlin (the wizard) to do things, and Kotlin does them!

## 🚀 What does it do?

1.  **Secret Message**: You click a button, and Flutter calls Kotlin. Kotlin replies: *"Hello from separate Kotlin class!"*
2.  **Cool Drawing**: You click "Import Your Design", and Kotlin draws a **Turbo Speedometer** 🏎️ from scratch and shows it right inside the Flutter app!

---

## 🧠 How does the Magic Work? 

Here is the secret sauce ! 🌶️

### 1. The Telephone: MethodChannel 📞
**What is it?**
A bridge that lets Flutter and Android talk to each other.

**How we used it:**
*   **Flutter side**: We pick up the phone using `MethodChannel('com.example.../drawing')` and say "invoke `getNativeMessage`".
*   **Kotlin side**: We have a listener in `MainActivity.kt`. When it hears "getNativeMessage", it asks our helper class `NativeHandler` for the answer and sends it back.

### 2. The Artist: Custom Drawing (Kotlin) 🎨
**What is it?**
We didn't use an image! We drew the speedometer using code, pixel by pixel.

**Tools we used in `ComplexDrawingView.kt`:**
*   **`Canvas`**: This is our digital paper.
*   **`Paint`**: This is our brush. We set colors, thickness, and styles (stroke or fill).
*   **`Path`**: This connects dots to make complex shapes (like the needle pointer).
*   **`SweepGradient`**: This creates the colorful rainbow ring 🌈 around the speedometer.
*   **`onDraw()`**: This is the loop where the drawing happens. Every time the screen updates, this function runs.

### 3. The Window: PlatformView 🖼️
**What is it?**
Flutter normally draws everything itself (like a game engine). But sometimes, we want to show a **Real Android View**. `PlatformView` cuts a hole in the Flutter screen and puts the Android view inside.

**How Flutter "sees" the design:**
1.  **The Factory (`ComplexViewFactory`)**: We built a factory in Kotlin that knows how to create our Speedometer.
2.  **Registration**: We told the Flutter Engine: *"Hey, if anyone asks for `complex-drawing-view`, use this factory!"*
3.  **The Widget (`AndroidView`)**: In Dart, we used the `AndroidView` widget. It tells Flutter to look for that registered factory and display whatever it creates.

---

## 🛠️ Tech Stack

*   **Flutter**: UI & Logic (Dart)
*   **Kotlin**: Native Android Logic & Drawing
*   **MethodChannel**: Communication
*   **PlatformView**: Embedding Native Views

## 🎮 How to run it?

1.  Open this folder on your computer.
2.  Connect your Android phone.
3.  Type `flutter run` in the terminal.
4.  Tap the buttons and see the magic!

## 📂 Where is the code?

*   **The Screen (Flutter)**: `lib/main.dart`
*   **The Wizard (Kotlin)**: `android/app/src/main/kotlin/com/example/flutter_kotlin_drawing/`
    *   `NativeHandler.kt`: The brain that answers questions.
    *   `ComplexDrawingView.kt`: The artist that draws the speedometer (Canvas logic).
    *   `ComplexViewFactory.kt`: The machine that builds the view for Flutter.
    *   `MainActivity.kt`: The headquarters where everything is connected.

## 🎥 Demo Video
https://github.com/user-attachments/assets/12f42400-5066-498a-8014-56c5ed522482

