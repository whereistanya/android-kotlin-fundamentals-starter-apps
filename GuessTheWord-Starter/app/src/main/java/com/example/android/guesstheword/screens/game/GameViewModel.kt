package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The current word
    var word = ""

    // The current score
    var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created")

        resetList()
        nextWord()
    }


    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed")
    }


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf( // Shortened for testing
                "guitar",
                "elephants",
                "noisy dog",
                "kid",
                "hooligan",
                "ride on lawnmower",
                "corn"
        )
        wordList.shuffle()
    }


    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
    }
}