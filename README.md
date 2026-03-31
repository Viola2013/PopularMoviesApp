# Popular Movies App

**Android Nanodegree | Project 1 & 2**

Welcome to the **Popular Movies App**! This application allows users to discover the most popular and highest-rated movies playing, fetching data directly from The Movie Database (TMDb) API.

## 🚀 Recent Modernization & Changes

The project has recently undergone significant updates to align with modern Android development standards:

- **Kotlin Migration**: The entire application has been migrated from Java to Kotlin for better safety, conciseness, and modern language features.
- **Coroutines & Jetpack**: Replaced legacy `AsyncTask` with **Kotlin Coroutines** and **Lifecycle-aware components** for robust background data fetching.
- **Improved UI/UX**:
    - Added a **Welcome & Usage View** on the main screen to explain the app's purpose and how to navigate it.
    - Enhanced layout responsiveness using `LinearLayout` and optimized `GridView` configurations.
- **Quality Assurance**: Introduced a **Smoke Unit Test Set** (using JUnit 4) to verify core data models, poster path generation, and formatting logic.
- **Updated Dependencies**: Modernized the build configuration with stable versions of `androidx`, `material`, `picasso`, and `kotlin-parcelize`.

## ✨ Features

### Stage 1: Core Experience
- **Movie Grid**: Displays a grid arrangement of movie posters upon launch.
- **Sorting Options**: Users can toggle between "Most Popular" and "Highest Rated" via the action bar menu.
- **Details Screen**: Tapping a poster opens a detailed view including:
    - Original Title
    - High-quality Movie Poster thumbnail
    - Plot Synopsis (Overview)
    - User Rating (Vote Average)
    - Release Date (Localized format)

### Stage 2: Enhanced Functionality
- **Trailers**: View and play movie trailers.
- **Reviews**: Read user reviews for selected movies.
- **Favorites**: Mark movies as favorites and store them locally for offline access.
- **Favorite Filter**: A new sorting pivot to view your collection of favorite movies.

## 🛠️ Technical Implementation
- **Data Source**: [The Movie Database (TMDb) API](https://www.themoviedb.org/documentation/api)
- **Image Loading**: [Picasso](https://square.github.io/picasso/) for efficient image caching and display.
- **Data Persistence**: `Parcelable` implementation via `@Parcelize` for seamless data transfer between activities.
- **Testing**: Local unit tests to ensure data integrity.

## 📖 What I Learned
- Fetching and parsing JSON data from a REST API.
- implementing custom `Adapters` for `GridView` and `ListView`.
- Managing background tasks with **Coroutines** and `lifecycleScope`.
- Designing responsive UIs that adapt to different screen sizes.
- Writing unit tests to ensure application stability.

---
*Originally developed as part of the Android Nanodegree (Updated 2024).*
