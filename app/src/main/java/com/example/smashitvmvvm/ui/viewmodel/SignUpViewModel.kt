package com.example.smashitvmvvm.ui.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.consants.ErrorConstants
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.calls.auth.SignUpCall
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.regex.Pattern
import kotlin.math.sign

class SignUpViewModel : ViewModel(), NetworkCallResponse {

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
        override fun afterTextChanged(editable: Editable?) {
            name = editable.toString()
            when {
                name.trim().isEmpty() -> nameValidator.value = ErrorConstants.EMPTY
                name.trim().length < 4 -> nameValidator.value = ErrorConstants.LENGTH
                characterRegex.matcher(name.trim()).find() -> nameValidator.value = ErrorConstants.INVALID_CHAR
                name.trim().matches(numberRegex) -> nameValidator.value = ErrorConstants.NUMBER
                else -> nameValidator.value = ErrorConstants.NO_ERROR
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val emailListener = object : TextWatcher{
        override fun afterTextChanged(editable: Editable?) {
            email = editable.toString()
            when {
                email.trim().isEmpty() -> emailValidator.value = ErrorConstants.EMPTY
                email.trim().length < 5 -> emailValidator.value = ErrorConstants.LENGTH
                !(email.trim().matches(emailRegex)) -> emailValidator.value = ErrorConstants.INVALID_EMAIL
                else -> emailValidator.value = ErrorConstants.NO_ERROR
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val passwordListener = object : TextWatcher{
        override fun afterTextChanged(editable: Editable?) {
            password = editable.toString()
            when {
                password.trim().isEmpty() -> passwordValidator.value = ErrorConstants.EMPTY
                password.trim().length < 8 -> passwordValidator.value = ErrorConstants.LENGTH
                !(password.trim().matches(prdRegex)) -> passwordValidator.value = ErrorConstants.INVALID_PASSWORD
                else -> passwordValidator.value = "no_error"
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    fun makeSignUpCall(name : String,email : String, password : String,
    newsLetter : Int, notifications :Int){
        val signUpCall = SignUpCall()
        signUpCall.postSignUpCall(name = name,email = email, password = password,
        newsletter = newsLetter,notificationsOpted = notifications, mCallback = this)
    }

    override fun networkCallResponse(
        result: Boolean,
        apiTag: String,
        responseBody: Response<ResponseBody>
    ) {

    }

    override fun networkFailureResponse(result: Boolean, apiTag: String, throwable: Throwable) {

    }

}