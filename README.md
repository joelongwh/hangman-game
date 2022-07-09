# hangman-game
Command line version of the classic hangman game

Description:
Hangman is a paper and pencil guessing game for two or more players. One player thinks of a word, phrase or sentence and the other tries to guess it by suggesting letters within a certain number of guesses.

Features:
- The player is given 8 guesses, deducted only if the guessed letter does not exist in the hidden word
- The hidden word is displayed, with a dash marking any hidden letters
- A list of previously guessed letters is also displayed 
- If the player guesses a previously guessed letter, a message is displayed indicating as such and they are allowed to guess again
- The hidden word will be selected at random from a pre-populated list of words

Assumptions:
- The hidden words is in all uppercase
- Guesses are not case sensitive
- The player will always give an appropriate input (i.e., a single letter)
- Words will not contain any punctuation
- Words will be a single word (not a phrase)
