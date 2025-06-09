FAN: Functional Assistant Navigator
FAN (Functional Assistant Navigator) is a modern, AI-enhanced Augmentative and Alternative Communication (AAC) application for Android. It is designed to provide a fast and intuitive communication experience by leveraging predictive AI to suggest words and phrases in real-time.

✨ Features (MVP)
Dynamic Word Grid: A clean, grid-based layout for core vocabulary.

Sentence Composition: Tap words to add them to the composition bar.

Text-to-Speech (TTS): A clear "Speak" button to vocalize the constructed sentence.

AI-Powered Suggestions: Real-time word predictions powered by the Gemini API to accelerate communication.

Simple & Accessible UI: A high-contrast, easy-to-navigate interface built with Jetpack Compose.

🛠 Tech Stack & Architecture
100% Kotlin: Including Coroutines and Flow for asynchronous operations.

Jetpack Compose: For building the entire UI declaratively.

MVVM Architecture: To create a clear separation of concerns between UI, state, and business logic.

Firebase: Used for:

Analytics: Understanding user engagement.

Firestore: Storing vocabulary and user data.

Coil: For fast, efficient, and Compose-native image loading.

Gemini API: To provide intelligent word predictions.

Material 3: For modern UI components and styling.

🚀 Getting Started
Prerequisites
Android Studio Iguana | 2023.2.1 or later

A Firebase project

A Gemini API Key

Setup Instructions
Clone the repository:

git clone https://github.com/your-username/fan-android.git

Firebase Configuration:

Go to your Firebase Console, select your project, and register your Android app (ensure the package name matches the one in build.gradle.kts).

Download the google-services.json file and place it in the app/ directory of the project.

API Key:

Obtain an API key from Google AI Studio.

Open the local.properties file in your project's root directory (create it if it doesn't exist).

Add your API key to the file:

GEMINI_API_KEY="YOUR_API_KEY_HERE"

The project uses this key via a build configuration field in build.gradle.kts.

Build and Run:

Sync the project with Gradle files.

Build and run the app on an emulator or a physical device.

🌿 Branching Strategy
This project uses a main-feature branching model.

main: This branch contains stable, production-ready code. Direct pushes to main are forbidden.

feature/{feature-name}: All new features, bug fixes, and development work must be done in a feature branch. When work is complete, open a Pull Request to merge the feature branch into main.

Example:

# Start a new feature
git checkout -b feature/add-new-vocabulary-category

# ... do your work and commit changes ...

# Push to the remote repository
git push origin feature/add-new-vocabulary-category

# Open a Pull Request on GitHub

This README and development plan were generated to bootstrap the FAN project.