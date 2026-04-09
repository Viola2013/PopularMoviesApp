# Popular Movies App

**Android Nanodegree | Project 1 & 2**

Welcome to the **Popular Movies App**! This application allows users to discover the most popular and highest-rated movies playing, fetching data directly from The Movie Database (TMDb) API.

## 🚀 Recent Modernization & Changes

The project has recently undergone significant updates to align with modern Android development standards (2024/2025):

- **Jetpack Compose Migration**: The UI has been modernized using **Jetpack Compose**, moving away from legacy XML-based layouts for a more reactive and declarative UI.
- **Kotlin & Coroutines**: fully migrated to Kotlin, utilizing **Coroutines** and `Flow` for asynchronous operations and state management.
- **Modern Build System**: 
    - Updated to **Gradle 9+** and **Android Gradle Plugin 9+**.
    - Configured with `dependencyResolutionManagement` in `settings.gradle` for centralized repository management.
    - Uses modern `compilerOptions` DSL for Kotlin configuration.
- **Image Loading**: Integrated **Coil** (in addition to Picasso) for modern, Compose-friendly image loading.
- **Architecture**: implemented **MVVM (Model-View-ViewModel)** architecture with `ViewModel` and `Lifecycle-aware` components.
- **Quality Assurance**: Updated **Smoke Unit Test Set** to ensure data integrity and logic correctness.

## ✨ Features

### Stage 1: Core Experience
- **Movie Grid**: Displays a grid of movie posters using Compose's `LazyVerticalGrid`.
- **Sorting Options**: Toggle between "Most Popular" and "Highest Rated" dynamically.
- **Details Screen**: Comprehensive movie information including:
    - Original Title
    - High-quality Movie Poster thumbnail
    - Plot Synopsis (Overview)
    - User Rating (Vote Average)
    - Release Date

### Stage 2: Enhanced Functionality
- **Trailers**: Seamlessly play movie trailers.
- **Reviews**: Access and read user reviews.
- **Favorites**: Local persistence for favorite movies using modern storage solutions.
- **Favorite Filter**: Quickly access your curated movie collection.

## 🛠️ Technical Implementation
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Data Source**: [The Movie Database (TMDb) API](https://www.themoviedb.org/documentation/api)
- **Image Loading**: [Coil](https://coil-kt.github.io/coil/) and [Picasso](https://square.github.io/picasso/)
- **Asynchronous Work**: Kotlin Coroutines & Lifecycle Scopes
- **Dependency Management**: Gradle Version Catalogs (or modernized build.gradle)

## 📖 What I Learned
- Building complex, responsive UIs with **Jetpack Compose**.
- Managing application state with `ViewModel` and `Compose State`.
- Handling background data fetching and error handling with **Coroutines**.
- Configuring and maintaining a modern Android build environment.
- Migrating from legacy Android patterns (Java/XML) to modern ones (Kotlin/Compose).

---
*Updated for Modern Android Standards (2025).*
