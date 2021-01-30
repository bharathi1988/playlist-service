## Playlist Service
- - - - - - 

````
Given an empty playlist
When an song is added
Then the playlist has 1 song
````

### API Specification
|URL|Request Method|Status|Description|
|---|--------------|------|-----------|
|api/v1/playlist/{playlist_id}/{song_id} |PATCH|201 Created|Returns the Entire Playlist with the Songs|

