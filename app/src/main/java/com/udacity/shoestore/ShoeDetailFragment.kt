package com.udacity.shoestore

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.shoelisting.ShoeListingViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    private lateinit var binding : FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)

        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.shoe_detail)


        // For Enabling / Disabling Save button
        setUpTextWatchers()

        // Get viewModel
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)

        // bind the xml's data variable
        binding.shoeListingViewModel = viewModel

        // Navigate back to Shoe Listing View
        binding.btCancel.setOnClickListener { view : View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }

        // On Save add the new shoe to the list
        binding.btSave.setOnClickListener {
            viewModel.addShoe()
        }

        viewModel.navigateBack.observe(viewLifecycleOwner, Observer {
            if(it) {
                // Let the view model know that we are navigating back,
                // make it false
                viewModel.successfullyNavigated()

                // Navigate back
                findNavController(this).navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
            }
        })

        return binding.root
    }

    private fun setUpTextWatchers() {
        binding.etShoeCompany.addTextChangedListener(textWatcher)
        binding.etShoeDesc.addTextChangedListener(textWatcher)
        binding.etShoeName.addTextChangedListener(textWatcher)
        binding.etShoeSize.addTextChangedListener(textWatcher)
    }

    //Notifying the changes in edit text field
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        // Enable the save button only if something is there in each field
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.btSave.isEnabled =
                binding.etShoeCompany.text.isNotEmpty() && binding.etShoeName.text.isNotEmpty()
                        && binding.etShoeDesc.text.isNotEmpty() && binding.etShoeSize.text.isNotEmpty()
        }
    }



}