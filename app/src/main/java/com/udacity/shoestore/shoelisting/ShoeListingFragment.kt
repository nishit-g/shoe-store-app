package com.udacity.shoestore.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen
        return inflater.inflate(R.layout.fragment_shoe_listing, container, false)
    }

}