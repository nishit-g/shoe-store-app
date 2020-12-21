package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);

        // Unable to hide the action bar - How do I do it ?
//        this.requireActivity().actionBar?.hide()

        (activity as AppCompatActivity).supportActionBar?.hide()

        // Edit Text fields
        val email : EditText = binding.etEmail
        val password : EditText = binding.etPass

        // Buttons
        val btRegister : Button = binding.btRegister
        val btLogin : Button = binding.btLogin

        //TODO : Save status that the user has logged in using LiveData

        // If Already registered : Directly Login -> move to Welcome fragment
        btLogin.setOnClickListener{ view:View ->
            //Navigate to Welcome Fragment
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // If email and password given then navigate to welcome fragment
        // Else show Toast : Require credentials
        btRegister.setOnClickListener {view:View ->
            if(email.text.isNotBlank() && password.text.isNotBlank()){
                //Navigate to Welcome Fragment
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
            else{
                Toast.makeText(requireContext(),"Enter your credentials first", Toast.LENGTH_SHORT).show()
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}