package com.example.smashitvmvvm.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.ActivitySplashBinding
import com.example.smashitvmvvm.sessionprefs.SessionPreferences
import com.example.smashitvmvvm.ui.base.BaseActivity
import com.example.smashitvmvvm.ui.handler.SplashHandler
import com.example.smashitvmvvm.ui.viewmodel.SplashViewModel

class SplashActivity : BaseActivity(), SplashHandler {

    private lateinit var bindingSplashBinding : ActivitySplashBinding
    private lateinit var splashViewModel : SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        sessionPreferences = SessionPreferences(this)
        setupViewModelAndHandler()
        setupAuthTokenObserver()
        determineNextActivity()
    }

    private fun setupViewModelAndHandler(){
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        bindingSplashBinding.splashHandler = this
        bindingSplashBinding.splashViewModel = splashViewModel
    }

    private fun setupAuthTokenObserver(){
        splashViewModel.getTokenLiveData().observe(this,
            Observer<String> { t ->
                val intent: Intent = if(t.isEmpty())
                    Intent(applicationContext,AuthActivity::class.java)
                else
                    Intent(applicationContext,MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
            })
    }

    private fun determineNextActivity(){
        Handler(Looper.myLooper()!!).postDelayed({
            splashViewModel.checkToken(sessionPreferences?.getAuthToken()!!)
        },2500)
    }
}