# Ktor-Koin-Clean

A clean, scalable Android boilerplate using Ktor for HTTP (GET/POST), Koin for DI, MVVM, and Clean Architecture. Follows SOLID principles with separate data, domain, and presentation layers. Ideal for building testable, modular apps with clear responsibility separation.

🧱 Ktor + Koin + MVVM + Clean Architecture (Android Example)

A robust, scalable, and maintainable Android project that demonstrates how to integrate:

✅ Ktor for lightweight HTTP client calls (GET & POST)

✅ Koin for dependency injection

✅ MVVM (Model-View-ViewModel) for separation of concerns

✅ Clean Architecture to structure code across layers (Data, Domain, Presentation)

🎯 Why This Project?

This project aims to clearly showcase how to build Android apps that are:

🔍 Modular – separating responsibilities cleanly across layers

🧼 Clean – following SOLID principles to ensure code is testable, readable, and easy to maintain

🚀 Production-Ready – suitable foundation for real-world Android apps

🔁 Scalable – easily extendable with additional features


🏗️ Architecture Overview

app/

 └─ src/main/java/com/example/ktorclean/
 
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

