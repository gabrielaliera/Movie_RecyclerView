# AND101 Project 6 - CYOAPI Part 2: RecyclerView Edition

Submitted by: **Gabriela Liera**

Time spent: **5** hours spent in total

## Summary

**Top 20 Trending Movies** is an android app that displays a scrollable list of the top trending movies from the <a href="https://www.themoviedb.org/?language=en-US">Movie Database API</a>. Users can view the movie poster, title and average movie rating.

If I had to describe this project in three (3) emojis, they would be: **✨📽🎉**

## Application Features

The following REQUIRED features are completed:

- [x] Make an API call to an API of your choice using AsyncHTTPClient
- [x] Implement a RecyclerView to display a list of entries from the API
- [x] Display at least three (3) pieces of data for each RecyclerView item

The following STRETCH features are implemented:

- [ ] Add a UI element for the user to interact with API further
- [x] Show a `Toast` or `Snackbar` when an item is clicked
- [x] Add item dividers with `DividerItemDecoration`

The following EXTRA features are implemented: None


## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<img src='https://github.com/gabrielaliera/Movie_RecyclerView/blob/master/movie-walkthrough.gif' title='Video Demo' width='300' heigth="500" alt='Video Demo' />
GIF created with <a href="https://www.cockos.com/licecap/">LICEcap.</a> 


## Notes

Throughout this project, I expanded my knowledge of working with API requests and data within Android Studio. Starting with an unfamiliar API, I studied the documentation to learn about authentication and query parameters required to retrieve a JSON object containing movie information. Using AsyncHTTPClient, I successfully executed an API call and retrieved the data. I then implemented a RecyclerView to display a scrolling list of the retrieved movie data and added item dividers using DividerItemDecoration. To provide further functionality, I also implemented a Toast message that would show when an item was clicked within the RecyclerView.

While working on this project, I encountered a challenge in modifying my mutable list I pass to the Adapter. I found that converting the element the list from a string to a JSON object allowed me more flexibility to properly manipulate the data and retrieve the necessary movie information. Additionally, I gained further knowledge of XML in managing image aspect ratios to ensure the movie poster was not cropped.

Overall, this project allowed me to strengthen my skills in working with API requests and data in Android Studio, as well as displaying that data within a RecyclerView.

## License

Copyright **2023** **Gabriela Liera**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
