package com.ashique.vocabblyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_details, container, false)
    }

    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.wordData.observe(viewLifecycleOwner) { word ->
            view.findViewById<TextView>(R.id.word).text = word.word
            val meaning  = word.meaning.joinToString("; ")
            view.findViewById<TextView>(R.id.tvDefinition).text = meaning
            view.findViewById<TextView>(R.id.tvExample1).text = word.example[0]
            view.findViewById<TextView>(R.id.tvExample2).text = word.example[1]
        }

        if(param1 == 1) {
            view.findViewById<ConstraintLayout>(R.id.cl_correct).visibility = View.VISIBLE
            view.findViewById<ConstraintLayout>(R.id.cl_incorrect).visibility = View.GONE
        } else {
            view.findViewById<ConstraintLayout>(R.id.cl_incorrect).visibility = View.VISIBLE
            view.findViewById<ConstraintLayout>(R.id.cl_correct).visibility = View.GONE
        }
        view.findViewById<Button>(R.id.btnNextWord).setOnClickListener {
            sharedViewModel.loadNextWord()
            parentFragmentManager.beginTransaction().replace(R.id.gre_fragment_container, WordQuizFragment()).commit()
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WordDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            WordDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}