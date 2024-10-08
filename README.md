# Meetmax
Meetmax is a modern social media app.



[![Say Thanks!](https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg)](https://saythanks.io/to/mohak1283)

## Note
This repository is still under development and I will continue to add more features to it.

## Demo Video
-[Drive Link](https://drive.google.com/file/d/1zPt_nsCJOh2PS_SIvn4nNh3mEO6WmFIp/view?usp=sharing)

## Techs Used 💻
- 100% [Kotlin](https://kotlinlang.org/) based
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - modern toolkit for building native Android UI.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) & [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) -  Kotlin libraries for asynchronous programming and reactive streams, respectively.
- [Dagger-Hilt](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that is lifecycle aware (didn't destroyed on UI changes).
- [Android Architecture Components](https://developer.android.com/topic/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- [Firebase](https://firebase.google.com/) - This involves configuring the necessary Firebase services (such as Firestore, FCM, Storage, and Authentication).
- [Room Database](https://developer.android.com/training/data-storage/room) - save data in a local database



## Screenshots


<p>
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/login.jpg?raw=true" alt="feed example" width = "400" >
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/signpup.jpg?raw=true" alt="upload photo example" width = "400" >
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/forgetpass.jpg?raw=true" alt="go to a profile from feed" width = "400">

<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/home1.jpg?raw=true" alt="go to a profile from feed" width = "400">
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/home2.jpg?raw=true" alt="go to a profile from feed" width = "400">
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/post.jpg?raw=true" alt="go to a profile from feed" width = "400">
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/event.jpg?raw=true" alt="go to a profile from feed" width = "400">

<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/permission.jpg?raw=true" alt="edit profile example" width = "400" >
<img src="https://github.com/saif-uddin-shrabon/PhotoLibrary/blob/main/Meetmax/creatpost.jpg?raw=true" alt="comment and activity feed example" width = "400">


</p>


## Getting started


#### 2. Clone the repo

```sh
$ git clone https://github.com/saif-uddin-shrabon/Meetmax-Clone
```

#### 3. Setup the firebase app
*Note : Now my firebase instanse are added. If you want to change then follow this step.

1. You'll need to create a Firebase instance. Follow the instructions at https://console.firebase.google.com.
2. Once your Firebase instance is created, you'll need to enable anonymous authentication.

* Go to the Firebase Console for your new instance.
* Click "Authentication" in the left-hand menu
* Click the "sign-in method" tab
* Click "Google" and enable it


4. Enable the Firebase Database
* Go to the Firebase Console
* Click "Database" in the left-hand menu
* Click the Cloudstore "Create Database" button
* Select "Start in test mode" and "Enable"

5. (skip if not running on Android)

* Create an app within your Firebase instance for Android, with package name com.lilab.meetmax
* Run the following command to get your SHA-1 key:


* In the Firebase console, in the settings of your Android app, add your SHA-1 key by clicking "Add Fingerprint".
* Follow instructions to download google-services.json
* place `google-services.json` into `/android/app/`.

