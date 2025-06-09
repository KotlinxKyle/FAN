FAN: Functional Assistant Navigator - 48-Hour Plan
1. Concept & Acronym
   App Name: FAN

Acronym: Functional Assistant Navigator

Core Mission: To empower non-verbal individuals with a fast, intuitive, and intelligent communication tool. FAN differentiates itself from existing apps by integrating AI to predict user intent, suggest relevant vocabulary, and streamline sentence construction.

2. Technology Stack & Architecture
   Language: Kotlin

UI Toolkit: Jetpack Compose

Architecture: Model-View-ViewModel (MVVM)

Asynchronous Operations: Kotlin Coroutines & Flow

Image Loading: Coil (Compose-native and efficient)

Backend & Analytics:

Firebase Firestore: For storing user vocabulary sets and AI model data (in the future).

Firebase Analytics: To gather usage metrics and user behavior insights.

AI Integration: Gemini API for predictive text generation.

Text-to-Speech: Android's native TTS Engine.

Version Control: Git

Branching Strategy: main for stable, production-ready code. All new work is done in feature/{feature-name} branches, which are then merged into main via Pull Requests.

3. The 48-Hour Sprint Plan
   Day 1: Foundation & Core Functionality (Hours 0-24)
   Phase 1: Project Setup & Configuration (Hours 0-2)
   [1 hr] Project Initialization:

Create a new Android Studio project using the "Empty Activity" template with Jetpack Compose.

Initialize a Git repository and create the main branch.

[1 hr] Firebase Integration:

Create a new project on the Firebase Console.

Register your Android app, download the google-services.json file, and place it in the app/ directory.

Add Firebase BoM and Analytics dependencies to your build.gradle.kts file.

Phase 2: Data Modeling & UI Scaffolding (Hours 3-10)
[2 hrs] Data Models:

Create Kotlin data classes:

Word(text: String, imageIdentifier: String, category: String)

Sentence(words: List<Word>)

[6 hrs] Compose UI Development:

MainScreen.kt: The primary composable that will host all other UI elements.

CompositionBar.kt: A Row at the top displaying the icons/text of selected words. Includes a "Speak" button and a "Clear" button.

WordGridView.kt: A LazyVerticalGrid to display the vocabulary.

WordCard.kt: A custom Card composable for each word, showing an icon (or image) and text. It will be the main interactive element.

SuggestionBar.kt: A LazyRow between the CompositionBar and WordGridView to display AI-powered word suggestions.

Phase 3: ViewModel & Core Logic (Hours 11-24)
[4 hrs] ViewModel Setup:

Create MainViewModel.kt.

Use StateFlow to manage the UI state:

_sentenceState = MutableStateFlow(Sentence())

_suggestionState = MutableStateFlow(emptyList<Word>())

[6 hrs] Business Logic:

Implement functions in the ViewModel:

addWordToSentence(word: Word)

clearSentence()

speakSentence()

fetchSuggestions()

[3 hrs] Text-to-Speech Integration:

Create a TtsHelper class that initializes the Android TextToSpeech engine.

Connect the speakSentence() function in the ViewModel to this helper.

[1 hr] Firebase Analytics Events:

Create an AnalyticsHelper to wrap Firebase logging.

Log initial events: sentence_spoken, word_added, sentence_cleared.

Day 2: AI Integration, Polish, & Release Prep (Hours 25-48)
Phase 4: AI Feature Integration (Hours 25-33)
[4 hrs] Gemini API Service:

Add Retrofit/Ktor dependencies to build.gradle.kts.

Define the Gemini API interface with a function to get word predictions.

Securely store your API key in your local.properties file.

[4 hrs] Connect AI to ViewModel:

In MainViewModel, update fetchSuggestions() to be a suspend function.

Use viewModelScope.launch to call the Gemini API.

The prompt should be constructed from the current words in the sentence: Prompt: "You are an AAC assistant. Based on the sentence so far: '${sentenceText}', provide three likely next words."

Update the _suggestionState with the results from the API, handling loading and error states.

Phase 5: Refinement & Testing (Hours 34-42)
[4 hrs] UI Polish:

Use Coil to asynchronously load icons/images in WordCard.kt.

Add subtle animations (animateContentSize) to the CompositionBar as words are added.

Ensure the layout is responsive and works well in both portrait and landscape modes.

Refine colors, typography, and spacing for a clean, accessible look.

[5 hrs] Manual QA & Debugging:

Rigorously test all user flows.

Check for race conditions or UI jank during API calls.

Verify that analytics events are correctly logged in the Firebase DebugView.

Fix all identified bugs.

Phase 6: Documentation & Release Preparation (Hours 43-48)
[2 hrs] Write README:

Finalize the README.md file based on the template below.

[2 hrs] App Icon & Branding:

Use Android Studio's "Image Asset Studio" to generate adaptive icons for the app.

[2 hrs] Prepare for Release:

Generate a signed AAB (Android App Bundle).

Take screenshots of the app for the store listing.

[2 hrs] Submit to Internal Testing:

Create the app listing in the Google Play Console.

Fill out all required details (description, privacy policy, etc.).

Upload the signed AAB to the Internal Testing track. This allows you to get the app onto devices for final testing without a public release.