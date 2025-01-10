package com.ashique.vocabblyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordQuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordQuizFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_quiz, container, false)
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.wordData.observe(viewLifecycleOwner) { word ->
            view.findViewById<TextView>(R.id.word).text = word.word
            val randomIndex = (0..1).random()
            val options = listOf(word.meaning[randomIndex], word.options[0], word.options[1], word.options[2])
            val shuffledOptions = options.shuffled()
            view.findViewById<TextView>(R.id.word_option4).text = shuffledOptions[0]
            view.findViewById<TextView>(R.id.word_option1).text = shuffledOptions[1]
            view.findViewById<TextView>(R.id.word_option2).text = shuffledOptions[2]
            view.findViewById<TextView>(R.id.word_option3).text = shuffledOptions[3]
        }

        view.findViewById<TextView>(R.id.word_option1).setOnClickListener {
            val meanings = sharedViewModel.wordData.value?.meaning
            val opt = view.findViewById<TextView>(R.id.word_option1).text
            var status = 0
            if(meanings?.contains(opt) == true) {
                status = 1
            }
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.slide_in_top,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            ).replace(R.id.gre_fragment_container, WordDetailsFragment.newInstance(status)).commit()
        }
        view.findViewById<TextView>(R.id.word_option2).setOnClickListener {
            val meanings = sharedViewModel.wordData.value?.meaning
            val opt = view.findViewById<TextView>(R.id.word_option2).text
            var status = 0
            if(meanings?.contains(opt) == true) {
                status = 1
            }
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.slide_in_top,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            ).replace(R.id.gre_fragment_container, WordDetailsFragment.newInstance(status)).commit()
        }
        view.findViewById<TextView>(R.id.word_option3).setOnClickListener {
            val meanings = sharedViewModel.wordData.value?.meaning
            val opt = view.findViewById<TextView>(R.id.word_option3).text
            var status = 0
            if(meanings?.contains(opt) == true) {
                status = 1
            }
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.slide_in_top,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            ).replace(R.id.gre_fragment_container, WordDetailsFragment.newInstance(status)).commit()
        }
        view.findViewById<TextView>(R.id.word_option4).setOnClickListener {
            val meanings = sharedViewModel.wordData.value?.meaning
            val opt = view.findViewById<TextView>(R.id.word_option4).text
            var status = 0
            if(meanings?.contains(opt) == true) {
                status = 1
            }
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.slide_in_top,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            ).replace(R.id.gre_fragment_container, WordDetailsFragment.newInstance(status)).commit()
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentGre.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = WordQuizFragment()
    }
}