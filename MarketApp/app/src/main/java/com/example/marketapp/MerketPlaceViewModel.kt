package com.example.marketapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Fragment - Activity, Fragment -Fragment kozotti adat kommunikaciora hasznaljuk
class MerketPlaceViewModel : ViewModel() {

    private val mutableProfile = MutableLiveData<ProfileEntity>()
    val selectedProfile: MutableLiveData<ProfileEntity> get() = mutableProfile


    //beallitjuk a kivalasztott ProfileEntity
    fun selectProfile(item : ProfileEntity?) {
        mutableProfile.value = item
    }


}