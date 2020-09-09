# Comics App

The application displays a comic on the screen. It's possible to get next random comic, read explantion or make it favorite

What is done:

- Clean architecture separating the code in layers
- Uses MVVM as the main architecture style
- Uses Dagger2 as the dependency injection framework
- Stores the received API response into Android Room database
- Uses RxJava2 for managing the data flow
- Uses Glide as the image loading library
- For navigation between screens uses Android Navigation library
- Unit tests are written with the help of mockk library
- Simple Motion layout scene is added on the Splash screen
- Simple resources are added for icons and drawables

Potential improvements:

- Complete the Favorite comic function and create a list of favorites. Also needs a POST to API updating the favorite field 
- Displaying error messages / retrying on failure
- Rx flow improvement with API extension, for example, get a list of Comics and make the App with similar functionality as Instagram including paging
- UI improvements adding functions for all the available data
- Implementation of the rest of requirements
