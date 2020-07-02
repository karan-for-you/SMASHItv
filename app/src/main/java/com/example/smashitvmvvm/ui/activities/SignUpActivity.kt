package com.example.smashitvmvvm.ui.activities

import android.content.Intent
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
        //setupButtonObserver()
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
                    ErrorConstants.EMPTY -> bindingSignUpBinding.tilName.error = "Name can't be empty"
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
                    ErrorConstants.EMPTY -> bindingSignUpBinding.tilEmail.error = "Email can't be empty"
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
                    ErrorConstants.EMPTY -> bindingSignUpBinding.tilPassword.error = "Password can't be empty"
                    ErrorConstants.LENGTH -> bindingSignUpBinding.tilPassword.error = "Password should be of minimum 8 characters"
                    ErrorConstants.INVALID_PASSWORD -> bindingSignUpBinding.tilPassword.error = "Password must contain a capital letter, a special character and a number "
                    else -> bindingSignUpBinding.tilPassword.error = null
                }
            })
    }

    private fun setupButtonObserver(){
        signUpViewModel.getButtonValidator().observe(this,
            Observer<Boolean> { t ->
                if(t!!)
                    bindingSignUpBinding.imageView.background = getDrawable(R.drawable.btnbackground)
                else
                    bindingSignUpBinding.imageView.background = getDrawable(R.drawable.btnbackground_disabled)
            })
    }


    override fun onSignUpClicked() {
        if(checkForErrors()) {
            if(bindingSignUpBinding.cbTermsConditions.isChecked){
                signUpViewModel.insertInUserDb(
                    bindingSignUpBinding.etName.text?.trim().toString(),
                    bindingSignUpBinding.etEmail.text?.trim().toString(),
                    bindingSignUpBinding.etPassword.text?.trim().toString()
                )
                startActivity(Intent(this,MainActivity::class.java))
            }else showToast("Please accept the terms and conditions")
        } else
            checkEmpties()
    }

    private fun checkForErrors(): Boolean {
        val fieldList = listOf(nameError, emailError, passwordError)
        for (s in fieldList) {
            if (s != ErrorConstants.NO_ERROR)
                return false
        }
        return true
    }

    private fun checkEmpties(){
        val errorFields = listOf(nameError,emailError,passwordError)
        val editTextList = listOf(bindingSignUpBinding.etName,bindingSignUpBinding.etEmail,bindingSignUpBinding.etPassword)
        val textInputLayoutFields = listOf(bindingSignUpBinding.tilName,bindingSignUpBinding.tilEmail,bindingSignUpBinding.tilPassword)
        for(i in errorFields.indices){
            if(errorFields[i] == "")
                textInputLayoutFields[i].error = ""+editTextList[i].hint+" can't be empty"
        }
    }


}