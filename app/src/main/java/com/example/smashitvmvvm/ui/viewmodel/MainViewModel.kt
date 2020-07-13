package com.example.smashitvmvvm.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.consants.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val bottomMenuLiveData = MutableLiveData<String>()

    fun getBottomMenuLiveData() : LiveData<String>{
        return bottomMenuLiveData
    }

    val onBottomNavigationViewItemListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> {
                    bottomMenuLiveData.value = Constants.HOME_FRAGMENT
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search ->{
                    bottomMenuLiveData.value = Constants.SEARCH_FRAGMENT
                    return@OnNavigationItemSelectedListener true
                }
                R.id.account ->{
                    bottomMenuLiveData.value = Constants.ACCOUNT_FRAGMENT
                    return@OnNavigationItemSelectedListener true
                }
                R.id.settings ->{
                    bottomMenuLiveData.value = Constants.SETTINGS_FRAGMENT
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener false
            }
        }

    fun setHomeLiveData(){
        bottomMenuLiveData.value = Constants.HOME_FRAGMENT
    }


}