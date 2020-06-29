package com.example.smashitvmvvm.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.consants.ErrorConstants
import com.example.smashitvmvvm.databinding.ActivitySignUpBinding
import com.example.smashitvmvvm.ui.base.BaseActivity
import com.example.smashitvmvvm.ui.handler.SignUpHandler
import com.example.smashitvmvvm.ui.viewmodel.SignUpViewModel

class SignUpActivity : BaseActivity(), SignUpHandler {

    private lateinit var bindingSignUpBinding: ActivitySignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    private var nameError = ""
    private var emailError = ""
    private var passwordError = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSignUpBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        setupViewModelAndHandler()
        setupNameObserver()
        setupEmailObserver()
        setupPasswordObserver()
    }

    private fun setupViewModelAndHandler(){
        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        bindingSignUpBinding.viewModel = signUpViewModel
        bindingSignUpBinding.handler = this
    }

    private fun setupNameObserver(){
        signUpViewModel.getNameValidation().observe(this,
            Observer<String> { t ->
                nameError = t
                when (t) {
                    ErrorConstants.LENGTH -> bindingSignUpBinding.tilName.error = "Name too short"
                    ErrorConstants.INVALID_CHAR -> bindingSignUpBinding.tilName.error = "Name contains invalid character"
                    ErrorConstants.NUMBER -> bindingSignUpBinding.tilName.error = "Name contains a number"
                    else -> bindingSignUpBinding.tilName.error = null
                }
            })
    }

    private fun setupEmailObserver(){
        signUpViewModel.getEmailValidation().observe(this,
            Observer<String> { t ->
                emailError = t
                when (t) {
                    ErrorConstants.LENGTH -> bindingSignUpBinding.tilEmail.error = "Email too short"
                    ErrorConstants.INVALID_EMAIL -> bindingSignUpBinding.tilEmail.error = "Invalid Email"
                    else -> bindingSignUpBinding.tilEmail.error = null
                }
            })
    }
    private fun setupPasswordObserver(){
        signUpViewModel.getPasswordValidation().observe(this,
            Observer<String> { t ->
                passwordError = t
                when (t) {
                    ErrorConstants.LENGTH -> bindingSignUpBinding.tilPassword.error = "Password should be of minimum 8 characters"
                    ErrorConstants.INVALID_PASSWORD -> bindingSignUpBinding.tilPassword.error = "Password must contain a capital letter, a special character and a number "
                    else -> bindingSignUpBinding.tilPassword.error = null
                }
            })
    }


    override fun onSignUpClicked() {
        if(checkForErrors())
            showToast("Cleared")
        else
            checkEmpties()
    }

    private fun checkForErrors(): Boolean{
        val fieldList = listOf(nameError,emailError,passwordError)
        for(s in fieldList){
            if(s != ErrorConstants.NO_ERROR)
                return false
        }
        return true
    }

    private fun checkEmpties(){
        val fieldList = listOf(nameError,emailError,passwordError)
        val editTextList = listOf(bindingSignUpBinding.etName,bindingSignUpBinding.etEmail,bindingSignUpBinding.etPassword)
        val textInputLayoutFields = listOf(bindingSignUpBinding.tilName,bindingSignUpBinding.tilEmail,bindingSignUpBinding.tilPassword)
        for(i in fieldList.indices){
            if(fieldList[i] == "")
                textInputLayoutFields[i].error = ""+editTextList[i].hint+" can't be empty"
        }
    }


}