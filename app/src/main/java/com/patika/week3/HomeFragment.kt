package com.patika.week3

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.patika.week3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    var number = 9995
    val STATEKEY = "savedNumber"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /**
         * Get number in state with the key if not null
         */
        if (savedInstanceState != null) {
            val stateNumber = savedInstanceState.getInt(STATEKEY, 0)
            number = stateNumber
        }

        Log.v("PATIKADEV", "onCreateView called.")

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("PATIKADEV", "onViewCreated called.")

        /**
         * gold gif added in imageview and number increased
         */
        fragmentHomeBinding.apply {
            Glide.with(requireContext()).load(R.drawable.gold).into(gifImageView)
            txvCounter.text = number.toString()
            btnCount.setOnClickListener {
                ++number
                txvCounter.text = number.toString()
            }

            txvCounter.addTextChangedListener(textWatcherEmail)
        }
    }

    /**
     * Watching text change and check number for landscape or portrait mode
     */
    private val textWatcherEmail = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            fragmentHomeBinding.apply {

                if (txvCounter.text.toString().toInt() == 9997) {
                    activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    Toast.makeText(requireContext(), "I did not forget", Toast.LENGTH_SHORT)
                        .show()
                }
                if (txvCounter.text.toString().toInt() == 9999) {
                    activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                    Toast.makeText(requireContext(), "Don't worry about it i won't forget :)", Toast.LENGTH_SHORT)
                        .show()
                }
                if (txvCounter.text.toString().toInt() == 10000) {
                    btnCount.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), "Counting completed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    /**
     * Added number to save
     *
     * @param outState
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v("PATIKADEV", "onSaveInstanceState called.")

        outState.putInt(STATEKEY, number)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v("PATIKADEV", "onViewStateRestored called.")
    }

    /**
     * This and below methods are examples for activity lifecycles.
     *
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v("PATIKADEV", "onAttach called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("PATIKADEV", "onCreate called.")

    }

    override fun onStart() {
        super.onStart()
        Log.v("PATIKADEV", "onStart called.")
    }

    override fun onResume() {
        super.onResume()
        Log.v("PATIKADEV", "onResume called.")
    }

    override fun onPause() {
        super.onPause()
        Log.v("PATIKADEV", "onPause called.")
    }

    override fun onStop() {
        super.onStop()
        Log.v("PATIKADEV", "onStop called.")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("PATIKADEV", "onDestroyView called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("PATIKADEV", "onDestroy called.")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("PATIKADEV", "onDetach called.")
    }
}