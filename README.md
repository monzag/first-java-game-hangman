# hangman-in-java

## Specification
Hangman game. Try to guess letters or whole word about world's capitals. You have 10 score. For bad letter you loose 1 score. Write whole word is more-risk - if you fail, you loose 2 score. But if you win - get extra 5 seconds less!

### **`Application.java`**

#### Methods:

##### `main`
Logic of application. Display welcome. Get data with capitals and countries and random choice once. Create objects: Player, Capital, Game. Start game's method runGame. Ask user about play again. If yes - the methods starts from the beginning.

##### `getCountriesFromFile`
Read data from file (line by line) and add lines to rows list. 
Returns rows. Catch except if file not exist.

Parameters:
* `file_name` - string

##### `getRandomIndex`
Get random index from rows list.
Returns index.

Parameters:
* `rows` - list

##### `getName`
Get input from user about his name. 
Return name.

##### `playAgain`
Ask user about play again. If user agree ('y') boolean want_play is true. Else is false.
Returns boolean want_play.


### **`LeaderBoard.java`**

#### Attributes:
* `records` - list with strings

#### Methods:

##### `getLeaderBoardFromFile`
Read data from file (line by line) and add them to records. Change list to string and return it. Catch exception when file not exist.

##### `saveLeaderBoard`
Write record to file. If file not exist - create new file. 
Catch exception.

Parameters:
* `record` - string

##### `saveNewRecord`
Create string to save with proper format and save to file. 

Parameters:
* `player` - object Player
* `capital` - object Capital
* `gameTime` - long
* `guessing` - integer

##### `displayLeaderBoard`
Get string from file, change it to list and print all line.


### **`Player.java`**

#### Attributes:
* `name` - string
* `score`- integer

#### Methods:

##### `getScore`
Returns score.

##### `setScore`
Set attribute score on argument.

Parameters:
* `score` - integer

##### `getName`
Returns name.


### **`Game.java`**

#### Attributes:
* `player` - object Player
* `capital` - object Capital
* `bad_answers` - list
* `gameTime` - long
* `guessing` - integer

#### Methods:

##### `runGame`
Logic of one game. Show hidden_word, score and list with bad answers. Get guess from user while score are greater than zero or user not win. After that time stop, display proper information (win/lose), add user result to highscore if win and display them. 

##### `getUserGuess`
Get input from user about his guess. Return this string.

##### `checkLength`
Check that user guess is letter or word (more than 1 sign). Start proper method.
Return boolean is_win.

Parameters:
* `guess` - string

##### `wordGuess`
Check that word entered by user is equal to capitalName. If yes, boolean is_win is true, else is false and user loose 2 score. 
Returns boolean is_win.

Parameters:
* `guess` - string

##### `letterGuess`
Check that letter entered by user occur in capitalName. If no, letter add to list bad_answers and user loose 1 score. If yes, check that all word is guess. If yes, boolean is_win is true. If not, set new hidden_word with exposed guessed letters. 
Returns boolean is_win.

Parameters:
* `letter` - char

##### `win`
Print string about win and user result (guessing, gameTime).

##### `loose`
Print string about loose game.

##### `changeScore`
Subtraction score for proper value.

Parameters:
* `subtract` - integer

##### `showHint`
Print hint with name of country. 


### **`Capital.java`**

#### Attributes:
* `capitalName` - string
* `country` - string
* `hiddenWord` - string

#### Methods:

##### `hide`
Create new string hidden_word which is hidding capitalName to underscore. If in capitalName occur space - to hidden_word add also space. Return this string.

##### `unhideLetters`
If guessedLetter entered by user occur in capitalName, change underscore in hidden_word to this letter. Returns hidden_word.

Parameters:
* `guessedLetter` - char

##### `getHiddenWord`
Returns hidden_word.

##### `setHiddenWord`
Set hidden_word as unhidden_letter. 

Parameters:
* `unhidden_letter` - string

##### `getCapitalName`
Returns capitalName.

##### `getCountry`
Returns name of country.


