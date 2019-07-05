## RockStars
This is a modular android Application built with a clean MVVM architecture.                       

## Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Room](https://developer.android.com/topic/libraries/architecture/room.html)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)
* [Koin](https://github.com/InsertKoinIO/koin)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Mockk](https://github.com/mockk/mockk/)
* [Quick permissions kotlin](https://github.com/QuickPermissions/QuickPermissions)
* [Circle image view](https://github.com/hdodenhof/CircleImageView)

## Requirements

* JDK 1.8
* [Android SDK](https://developer.android.com/studio/index.html)
* Android Q ([API 29](https://developer.android.com/preview/api-overview.html))
* Latest Android SDK Tools and build tools.

## Architecture

### Presentation

The presentation layer of this application include the views(fragments and activities) and the Viewmodels which interact with the data layer through Use cases defined in the domain layer.

### Screen shots

<img src="https://github.com/festuskiambi/rockstars/blob/master/screenshots/img1.jpg" width="425"/>  <img 
src="https://github.com/festuskiambi/rockstars/blob/master/screenshots/img2.jpg" width="425"/>

<img src="https://github.com/festuskiambi/rockstars/blob/master/screenshots/img3.jpg" width="425"/>  <img 
src="https://github.com/festuskiambi/rockstars/blob/master/screenshots/img4.jpg" width="425"/>

### Domain

The Domain Layer of this application has three primary purposes:
* Abstraction of the Data Layer of the application
* Providing a common set of Models 
* Providing a High-Level description of the applications primary functions based on problem domain analysis 

### Data

The Data Layer of this application contains implementations of the data sources which are described in the repository package of the domain layer.


**TODO:**

- Add instrumentation and unit tests in the presentation layer
- Complete the search feature
- Improve the user interface 
- Modularise presentation layer features
  

