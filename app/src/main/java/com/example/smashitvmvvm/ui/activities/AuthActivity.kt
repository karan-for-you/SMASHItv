package com.example.smashitvmvvm.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.ActivityAuthBinding
import com.example.smashitvmvvm.ui.base.BaseActivity
import com.example.smashitvmvvm.ui.handler.AuthHandler
import com.example.smashitvmvvm.ui.viewmodel.AuthViewModel

class AuthActivity : BaseActivity(), AuthHandler {

    private lateinit var bindingAuthBinding: ActivityAuthBinding
    private lateinit var authViewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAuthBinding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
        setupViewModelAndHandler()
    }

    private fun setupViewModelAndHandler(){
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        bindingAuthBinding.viewModel = authViewModel
        bindingAuthBinding.handler = this
    }

    override fun onLoginClicked() {
        startActivity(Intent(applicationContext,LoginActivity::class.java))
    }

    override fun onSignUpClicked() {
        startActivity(Intent(applicationContext,SignUpActivity::class.java))
    }
}