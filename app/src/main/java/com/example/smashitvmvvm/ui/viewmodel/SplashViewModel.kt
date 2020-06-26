package com.example.smashitvmvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    var tokenLiveData = MutableLiveData<String>()

    fun getTokenLiveData() : LiveData<String>{
        return tokenLiveData
    }

    fun checkToken(authToken : String){
        if(authToken.isNotEmpty())
            tokenLiveData.value = authToken
        else
            tokenLiveData.value = ""
    }

}