## Playlist Service
- - - - - - 

````
When a playlist is created with a name
Then a confirmation is returned that it was successful.
And the playlist is empty.

````

### API Specification
|URL|Request Method|Status|Description|
|---|--------------|------|-----------|
|/api/v1/playlist |POST|201 Created|Returns the Created Playlist |


````
When a playlist is created with a name
When a playlist is created without a name
Then a message is returned that a name is required.

````

### API Specification
|URL|Request Method|Status|Description|
|---|--------------|------|-----------|
|/api/v1/playlist |POST|400 Bad Request|Returns the Error Message Playlisname is required |



````
Given an empty playlist
When an song is added
Then the playlist has 1 song
````

### API Specification
|URL|Request Method|Status|Description|
|---|--------------|------|-----------|
|api/v1/playlist/{playlist_id}/{song_id} |PATCH|201 Created|Returns the Entire Playlist with the Songs|

