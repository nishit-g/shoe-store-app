package com.udacity.shoestore.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ShoeDetailLayoutBinding
import kotlinx.android.synthetic.main.shoe_detail_layout.view.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {

    // ViewModel
    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeListingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_listing,container,false)

        // initialize the view model
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)
        binding.shoeListingViewModel = viewModel

        // Observing the shoeList
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for(shoe in shoeList){
                val shoeDetailLayout: ShoeDetailLayoutBinding =  DataBindingUtil.inflate(inflater, R.layout.shoe_detail_layout, container, false)
                shoeDetailLayout.tvShoeCompany.text = shoe.company
                shoeDetailLayout.tvShoeName.text = shoe.name
                shoeDetailLayout.tvShoeDescription.text = shoe.description
                shoeDetailLayout.tvShoeSize.text = shoe.size.toString()

                binding.llMainListing.addView(shoeDetailLayout.root)
            }
        })


        binding.newShoeButton.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

}