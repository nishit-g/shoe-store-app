package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container, false)

        val btToInstruction : Button = binding.btInstruct;

        // Unable to hide the action bar - How do I do it ?
//        this.requireActivity().actionBar?.hide()

        (activity as AppCompatActivity).supportActionBar?.hide()

        // Move to Instruction Fragment
        btToInstruction.setOnClickListener {view : View ->
            view.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToIntstructionFragment())
        }

        return binding.root
    }

}