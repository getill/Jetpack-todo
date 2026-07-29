# Assistant Personnel Minimaliste (APM) : To-Do Minimaliste 📝

Bienvenue dans l'Assistant Personnel Minimaliste ! Ce projet Android a été conçu dans l'objectif principal d'offrir une expérience de gestion de tâches simple, rapide et apaisante (avec un thème sombre moderne), le tout en **Jetpack Compose**.

## Fonctionnalités

L'application permet à ses utilisateurs de :
* **Ajouter des tâches** : Définir un nom et une description claire pour vos objectifs de la journée.
* **Marquer comme terminé** : Valider et visualiser vos succès d'une simple pression du doigt.
* **Gérer (Éditer/Supprimer)** : Modifier ou effacer une tâche devenue obsolète.
* **Persistance 100% Locale** : L'outil ne requiert ni backend, ni connexion internet. Vos données vous appartiennent et sont conservées directement sur votre appareil (SharedPreferences avec un pont JSON - `Gson`).

## Stack Technologique

* **Langage** : Kotlin
* **UI Framework** : Android Jetpack Compose (Material 3)
* 
* **Architecture** : MVVM (Model-View-ViewModel) via StateFlows
* **Stockage de données** : `SharedPreferences` + `Gson`

## Comment installer et tester

### Solution 1 : Installer l'application compilée (.apk)
L'exécutable (`.apk`) vous permet de tester l'application sans utiliser d'outils de développement.
1. Depuis un appareil Android ou un Emulator, transférez et installez le fichier `app-debug.apk` généré dans `app/build/outputs/apk/debug/app-debug.apk`.
2. Autorisez l'installation d'applications de sources inconnues si prompté.

> *Via ADB* : `adb install app/build/outputs/apk/debug/app-debug.apk`

### Solution 2 : Construire via Android Studio
1. Clonez ce dépôt sur votre machine : `git clone [URL_DU_REPO]`
2. Ouvrez Android Studio, puis cliquez sur `Open` et sélectionnez le dossier racine du projet.
3. Patientez pendant la synchronisation Gradle.
4. Cliquez sur **Run** (Triangle vert) pour lancer APM sur l'émulateur ou le périphérique physique ciblé.

## Contribution ou modifications
L'équipe est libre d'étendre APM pour inclure de nouveaux modules (Journal d'humeur, carnets, etc).

*Développé dans le cadre d'un prototype épuré de développement logiciel (Février - Mars 2026).*
