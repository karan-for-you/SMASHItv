package com.example.smashitvmvvm.ui.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.consants.ErrorConstants
import com.example.smashitvmvvm.model.ValidationErrorInfo
import java.util.regex.Pattern

class SignUpViewModel : ViewModel() {

    var name = ""
    var email = ""
    var password = ""

    var termsAndConditionCheck = true
    var newsLetterCheck = false
    var notificationsCheck = true

    private val characterRegex = Pattern.compile(Constants.SPECIAL_CHAR_REGEX)
    private val numberRegex = Regex(Constants.NUMBER_REGEX)
    private val emailRegex = Regex(Constants.EMAIL_REGEX)
    private val prdRegex  = Regex(Constants.PRD_REGEX)

    var validationError = MutableLiveData<ValidationErrorInfo>()

    fun getValidationError() : LiveData<ValidationErrorInfo>{
        return validationError
    }

    var nameValidator = MutableLiveData<String>()

    fun getNameValidation() : LiveData<String>{
        return nameValidator
    }

    var emailValidator = MutableLiveData<String>()

    fun getEmailValidation() : LiveData<String>{
        return emailValidator
    }

    var passwordValidator = MutableLiveData<String>()

    fun getPasswordValidation() : LiveData<String>{
        return passwordValidator
    }


    val nameListener = object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            name = p0.toString()
            when {
                name.length < 5 -> nameValidator.value = ErrorConstants.LENGTH
                characterRegex.matcher(name).find() -> nameValidator.value = ErrorConstants.INVALID_CHAR
                name.matches(numberRegex) -> nameValidator.value = ErrorConstants.NUMBER
                else -> nameValidator.value = ErrorConstants.NO_ERROR
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val emailListener = object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            email = p0.toString()
            when {
                email.length < 5 -> emailValidator.value = ErrorConstants.LENGTH
                !(email.matches(emailRegex)) -> emailValidator.value = ErrorConstants.INVALID_EMAIL
                else -> emailValidator.value = ErrorConstants.NO_ERROR
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val passwordListener = object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            password = p0.toString()
            when {
                password.length < 8 -> passwordValidator.value = ErrorConstants.LENGTH
                !(password.matches(prdRegex)) -> passwordValidator.value = ErrorConstants.INVALID_PASSWORD
                else -> passwordValidator.value = "no_error"
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }



    fun validateSignUpInfo(name : String, email : String, password : String){
        val validationErrorInfo = ValidationErrorInfo()

        if(name.length < 5){
            validationErrorInfo.field = "name_field"
            validationErrorInfo.error = "Name should be more than 5 characters"
            validationError.value = validationErrorInfo
        }

        val pattern = Pattern.compile(Constants.PRD_REGEX)
        if(!pattern.matcher(password).matches()){
            validationErrorInfo.field = "pass_field"
            validationErrorInfo.error = "Invalid Password"
            validationError.value = validationErrorInfo
        }

    }

}