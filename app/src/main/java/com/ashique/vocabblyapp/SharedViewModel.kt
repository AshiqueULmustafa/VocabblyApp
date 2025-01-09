package com.ashique.vocabblyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _wordData = MutableLiveData<Word>()
    val wordData: LiveData<Word>
        get() = _wordData

    private val words = listOf(
        Word(
            "Abate",
            0,
            listOf("to lessen", "to reduce"),
            listOf("The storm abated", "The rain abated"),
            listOf("to increase", "to grow", "to rise")
        ),
        Word(
            "Aberrant",
            0,
            listOf("atypical", "deviating from the norm"),
            listOf("The behavior of the suspect was aberrant", "The aberrant behavior of the suspect"),
            listOf("normal", "typical", "usual")
        ),
        Word(
            "Abhor",
            0,
            listOf("to hate", "to detest"),
            listOf("She abhors dishonesty", "They abhor violence"),
            listOf("to love", "to admire", "to like")
        ),
        Word(
            "Benevolent",
            0,
            listOf("kind", "charitable"),
            listOf("The benevolent old man donated to the school", "Her actions were truly benevolent"),
            listOf("malevolent", "cruel", "selfish")
        ),
        Word(
            "Cacophony",
            0,
            listOf("harsh sound", "discordant noise"),
            listOf("The room was filled with a cacophony of laughter", "The city streets echoed with cacophony"),
            listOf("harmony", "melody", "euphony")
        ),
        Word(
            "Daunt",
            0,
            listOf("to intimidate", "to discourage"),
            listOf("The challenge did not daunt her spirit", "He was daunted by the mountain's height"),
            listOf("to encourage", "to embolden", "to inspire")
        ),
        Word(
            "Ebullient",
            0,
            listOf("enthusiastic", "exuberant"),
            listOf("Her ebullient nature brightened the room", "He spoke in an ebullient tone"),
            listOf("apathetic", "indifferent", "reserved")
        ),
        Word(
            "Facetious",
            0,
            listOf("humorous", "not serious"),
            listOf("He made a facetious comment during the meeting", "Her facetious remarks lightened the mood"),
            listOf("serious", "earnest", "sincere")
        ),
        Word(
            "Gregarious",
            0,
            listOf("sociable", "friendly"),
            listOf("He was a gregarious person who loved parties", "Her gregarious nature made her popular"),
            listOf("introverted", "reserved", "antisocial")
        ),
        Word(
            "Harangue",
            0,
            listOf("a long, passionate speech", "a tirade"),
            listOf("The politician delivered a fiery harangue", "His harangue about the issue lasted an hour"),
            listOf("praise", "commendation", "compliment")
        ),
        Word(
            "Impetuous",
            0,
            listOf("rash", "hasty"),
            listOf("Her impetuous decision led to trouble", "He was known for his impetuous actions"),
            listOf("calm", "thoughtful", "cautious")
        )
    )

    private var currentIndex = 0
    fun loadNextWord() {
        if (currentIndex < words.size) {
            _wordData.value = words[currentIndex]
            currentIndex++
        }
    }
}