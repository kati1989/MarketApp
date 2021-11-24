package com.example.marketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity(), EditProfile.NotifySaveProfile {
    var marketDB : MarketDatabase? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveProfileClicked() {
        //lekerdezzuk a viewModelben levo PRofilt
        val viewModel: MerketPlaceViewModel by viewModels<MerketPlaceViewModel>()
        var p : ProfileEntity? =  viewModel.selectedProfile.value
        //perzisztaljuk a profilt.
        marketDB?.profileDao()!!.update(p!!)
    }
}