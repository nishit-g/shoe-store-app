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
import androidx.databinding.DataBindingUtil
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

        val email : EditText = binding.etEmail
        val password : EditText = binding.etPass

        val btRegister : Button = binding.btRegister
        val btLogin : Button = binding.btLogin

        // If Already registered : Directly Login -> move to Welcome fragment
        btLogin.setOnClickListener{
            //TODO : go to Welcome Fragment
            Toast.makeText(requireContext(),"Welcome Fragment will be shown", Toast.LENGTH_SHORT).show()
        }

        // If email and password given then move to welcome fragment
        // Else show Toast : Require credentials
        btRegister.setOnClickListener {
            if(email.text.isNotBlank() && password.text.isNotBlank()){
                //TODO : go to Welcome Fragment
                Toast.makeText(requireContext(),"Welcome Fragment will be shown", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(requireContext(),"Enter your credentials first", Toast.LENGTH_SHORT).show()
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}