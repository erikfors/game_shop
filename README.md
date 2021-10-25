# *IGame Shop*

**Game Shop** is a simple app that shows you information about the most popular games. With future improvment to send user to the pages where they can buy the games.

## User Stories

The following **required** functionality is completed:

- [x] All games load from the API
- [x] User can select any game to see all details
- [x] App is user friendly
- [x] Have an scalable architechture for the app
- [x] Manage app state
- [ ] Write Unit tests

The following **optional** features are implemented:

- [x] Show game image , and image load asyncronous 
- [x] Style the feed to look like the API recommendation.
- [x] Use pagination so each page in the API loads after the other.

## Fututre Stories

- [ ] Show a view more button in inittial list(show more info)
- [ ] Search bar to look for an specific game
- [ ] user can favorite the games
- [ ] User can see favorite games in a new screen
- [ ] User can add games to a shopping cart
- [ ] User is able to log in to track their data
- [ ] Detail screen have more data about the games
- [ ] user can search game by other methods
- [ ] add filtering 

The following **optional** features are future optionals:

- [ ] User sees app icon in home screen and styled bottom navigation view
- [ ] Style the feed to look even better.
- [ ] Add animations.
- [ ] User can have a profile
- [ ] User can edit their profile
- [ ] User can comment on games

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

This app uses [RAWG Video Games Database API](https://rawg.io/) - API where you can get broad information about games.

## Open-source libraries uses 

- [JetPack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [Retrofit](https://square.github.io/retrofit/) - turns your HTTP API into a Java interface.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started?authuser=2) - Easier navigation in android

## License

    Copyright [2021] [Erik Fors]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
