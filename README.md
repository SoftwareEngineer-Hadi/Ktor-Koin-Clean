# Ktor-Koin-Clean (Android-Compose)

A clean, scalable Android boilerplate using Ktor for HTTP (GET/POST), Koin for DI, MVVM, and Clean Architecture. Follows SOLID principles with separate data, domain, and presentation layers. Ideal for building testable, modular apps with clear responsibility separation.

<br/>

🧱 **Ktor + Koin + MVVM + Clean Architecture (Android)**

A robust, scalable, and maintainable Android project that demonstrates how to integrate:

✅ Ktor for lightweight HTTP client calls (GET & POST)

✅ Koin for dependency injection

✅ MVVM (Model-View-ViewModel) for separation of concerns

✅ Clean Architecture to structure code across layers (Data, Domain, Presentation)

<br/>

🎯 **Why This Project?**

This project aims to clearly showcase how to build Android apps that are:

🔍 Modular – separating responsibilities cleanly across layers

🧼 Clean – following SOLID principles to ensure code is testable, readable, and easy to maintain

🚀 Production-Ready – suitable foundation for real-world Android apps

🔁 Scalable – easily extendable with additional features

<br/>

🔧 **Tech Stack**

| Layer        | Technology                                                      |
| ------------ | --------------------------------------------------------------- |
| UI           | Jetpack Compose                                                 |
| ViewModel    | AndroidX ViewModel                                              |
| Networking   | **Ktor** (with `ktor-client-core`, `ktor-client-android`, etc.) |
| DI           | **Koin**                                                        |
| Architecture | MVVM + Clean Architecture                                       |
| Language     | Kotlin (100%)                                                   |

<br/>

🏗️ **Architecture Overview**

app <br/>
 └─ src/main/java/com/example/ktorkoin
 
    ├─ core/
    │   ├─ Either.kt
    │   ├─ Failure.kt
    │   └─ Mapper.kt  
    ├─ data/
    │   ├─ remote/
    │   │   ├─ KtorClientFactory.kt
    │   │   ├─ ApiRoutes.kt
    │   │   ├─ dto/
    │   │   │   ├─ PostDto.kt
    │   │   │   └─ NewPostRequest.kt
    │   │   └─ PostRemoteDataSource.kt
    │   ├─ repository/
    │   │   └─ PostRepositoryImpl.kt
    │   └─ di/DataModule.kt
    ├─ domain/
    │   ├─ entity/Post.kt
    │   ├─ repository/PostRepository.kt
    │   ├─ usecase/CreatePostUseCase.kt
    │   ├─ usecase/GetPostsUseCase.kt
    │   └─ di/DomainModule.kt
    ├─ presentation/
    │   ├─ post/PostViewModel.kt
    │   ├─ post/PostUiState.kt
    │   ├─ post/PostFragment.kt
    │   └─ di/PresentationModule.kt
    ├─ di/AppModules.kt
    └─ App.kt

