package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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

        // TODO : Move to Instruction Fragment
        btToInstruction.setOnClickListener {
            Toast.makeText(requireContext(),"To Instruction", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}