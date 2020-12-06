package com.udacity.shoestore.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

//    Shoe("Ghar ke Joote", 6.4, "Local", "ghar ke hain, ghar ke"),
//    Shoe( "Bhara ke Joote", 7.6, "Fike", "Bahar jaane ke liye hain")

class ShoeListingViewModel : ViewModel() {

    // shoeList
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()

    // Encapsulating the shoeList
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    //
    private val _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    init{
        _shoeList.value = mutableListOf()
        _newShoe.value = Shoe("", 0.0, "", "")
    }

    private fun shoeList() : MutableList<Shoe>{
        return mutableListOf(
            Shoe("Netflix", 6.4, "Adidas", "Very comfortable shoes"),
            Shoe( "Prime", 7.6, "Fike", "Gift for a friend"))
    }
}