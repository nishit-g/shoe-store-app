package com.udacity.shoestore.shoelisting

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

//    Shoe("Ghar ke Joote", 6.4, "Local", "ghar ke hain, ghar ke"),
//    Shoe( "Bhara ke Joote", 7.6, "Fike", "Bahar jaane ke liye hain")

class ShoeListingViewModel : ViewModel() {

    // shoeList
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    // Encapsulating the shoeList
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    //This will be data binded with ShoeDetailFragment XML
    private val _newShoe = MutableLiveData<Shoe>()
    // Encapsulating the _newShoe
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    //Navigate or not to navigate ? : Boolean
    private val _navigateBack = MutableLiveData<Boolean>()
    //Encapsulating the _navigateBack
    val navigateBack : LiveData<Boolean>
        get() = _navigateBack



    init{
        Timber.i("Initializing ViewModel again")
        _shoeList.value = getShoes()
        _newShoe.value = Shoe("", 0.0, "", "")
        _navigateBack.value = false
    }



    fun addShoe (){
        _shoeList.value?.add(_newShoe.value!!)

        _navigateBack.value = true

        Timber.i("Size of the shoe list -> %d", _shoeList.value?.size)

        // Since it's 2 way binding we need to empty it again
        _newShoe.value = Shoe("", 0.0, "", "")

    }

    fun getShoes() : MutableList<Shoe>{
        return mutableListOf(
            Shoe("Niikek", 3.2, "sldkfsdf", "asdlfkjasldkfasldf"),
            Shoe("Smokes", 2.6, "Holy", "second")
        )
    }

    fun successfullyNavigated() {
        _navigateBack.value = false
    }
}