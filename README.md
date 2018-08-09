<title>Kotlin MVP</title>

<body>
<b>Demo App developed Kotlin for Android</b></br></br>

This is a demo app developed using Kotlin for Android.It uses Model View Presenter (MVP) as architectural pattern.</br>
For the persistence layer was used Room. Also all the layouts were developed using Constrains Layouts.</br>
For the web service area, there is a dummy API generated on Apiary for the Login, Register and Get List sections, there are consumed in the app with Retrofit2 and using RXAndroid.</br>
Also the app includes dependency injections and Dagger2 was used for that part.</br>

The app itself consist on a Splash View, the Login and Register areas, because they are connected with a dummy web service, there is no real storage of the information on the cloud, this sections were developed for practice purposes. After that the app storage the user session and let you navigate through a list of articles related to Kotlin and enter into the detail of each one.</br>

The information displayed on the articles comes from the official Kotlin webpage on the reference area.</br>

The app is available on Google Play on:</br></br>

<a href="https://play.google.com/store/apps/details?id=com.josegrillo.kotlinmvp">Google Play Link</a></br></br>

The app uses the following libraries:</br></br>

- <a href="https://github.com/google/dagger">Dagger2</a></br>
- <a href="https://github.com/pnikosis/materialish-progress">Material-ish Progress</a></br>
- <a href="https://developer.android.com/topic/libraries/architecture/adding-components">Room</a></br></br>
- <a href="https://github.com/square/retrofit">Retrofit2</a></br></br>
- <a href="https://github.com/ReactiveX/RxJava">RxJava: Reactive Extensions for the JVM</a></br></br>
- <a href="https://github.com/ReactiveX/RxAndroid">RxAndroid: Reactive Extensions for Android</a></br></br>
- <a href="https://github.com/ihsanbal/LoggingInterceptor">LoggingInterceptor - Interceptor for OkHttp3 with pretty logger</a></br></br>
- <a href="https://github.com/bumptech/glide">Glide</a></br></br>

As reference for the definition of the architecture of the project the following resources were used as reference:</br></br>

- <a href="https://github.com/MindorksOpenSource/android-kotlin-mvp-architecture">Android Kotlin MVP Architecture: Sample App</a></br>
- <a href="https://github.com/mcatta/RoomDagger2Demo">RoomDagger2Demo</a></br></br>
- <a href="https://medium.com/google-developers/7-steps-to-room-27a5fe5f99b2">7 Steps To Room</a></br></br>
- <a href="https://medium.com/@ogulcan/kotlin-mvp-dagger-2-retrofit-sample-android-application-e6fe3af7acd">Kotlin + MVP + Dagger 2 + Retrofit = Sample Android Application</a></br>
- <a href="https://proandroiddev.com/mvp-architecture-with-kotlin-dagger-2-retrofit-rxandroid-and-databinding-17bffe27393d">MVP Architecture with Kotlin-Dagger 2, Retrofit, RxAndroid and DataBinding</a></br></br>
- <a href="https://antonioleiva.com/mvp-android/">MVP for Android: how to organize the presentation layer</a></br></br>

You could find me at LinkedIn on:</br></b>

<a href="https://www.linkedin.com/in/jos%C3%A9-enrique-grillo-hern%C3%A1ndez-4955645a/?locale=en_US">LinkedIn Profile</a></br></br>

<b>Screenshots</b></br></br>
<table>
<tr>
<td>
<img src="https://gitlab.com/grillo87/kotlin_mvp/raw/master/screenshots/Screenshot_1533822989.png">
</td>
<td>
<img src="https://gitlab.com/grillo87/kotlin_mvp/blob/master/screenshots/Screenshot_1533825907.png">
</td>
<td>
<img src="https://gitlab.com/grillo87/kotlin_mvp/blob/master/screenshots/Screenshot_1533825912.png">
</td>
</tr>
</table>


</body>
</html>