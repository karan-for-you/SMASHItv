package com.example.smashitvmvvm.ui.viewmodel

import android.app.Application
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.consants.ErrorConstants
import com.example.smashitvmvvm.db.AppDatabase
import com.example.smashitvmvvm.db.UserEntity
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.calls.auth.SignUpCall
import com.example.smashitvmvvm.utils.Logger
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.regex.Pattern

class SignUpViewModel(application : Application) : AndroidViewModel(application), NetworkCallResponse {

    private val db : AppDatabase =
        Room.databaseBuilder(application,AppDatabase::class.java,"user-list.db")
            .allowMainThreadQueries()
            .build()

    var name = ""
    var email = ""
    var password = ""

    var nameError = ""
    var emailError = ""
    var passwordError = ""

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

    var buttonValidator = MutableLiveData<Boolean>()

    fun getButtonValidator() : LiveData<Boolean>{
        return buttonValidator
    }


    val nameListener = object : TextWatcher{
        override fun afterTextChanged(editable: Editable?) {
            name = editable.toString()
            Logger.logError("Name OTG",name)
            when {
                name.trim().isEmpty() -> nameValidator.value = ErrorConstants.EMPTY
                name.trim().length < 4 -> nameValidator.value = ErrorConstants.LENGTH
                characterRegex.matcher(name.trim()).find() -> nameValidator.value = ErrorConstants.INVALID_CHAR
                name.trim().matches(numberRegex) -> nameValidator.value = ErrorConstants.NUMBER
                else -> nameValidator.value = ErrorConstants.NO_ERROR
            }
            nameError = nameValidator.value.toString()
            //checkButtonUIValidation(nameError,emailError,passwordError)
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val emailListener = object : TextWatcher{
        override fun afterTextChanged(editable: Editable?) {
            email = editable.toString()
            Logger.logError("Email OTG",email)
            when {
                email.trim().isEmpty() -> emailValidator.value = ErrorConstants.EMPTY
                email.trim().length < 5 -> emailValidator.value = ErrorConstants.LENGTH
                !(email.trim().matches(emailRegex)) -> emailValidator.value = ErrorConstants.INVALID_EMAIL
                else -> emailValidator.value = ErrorConstants.NO_ERROR
            }
            emailError = emailValidator.value.toString()
            //checkButtonUIValidation(nameError,emailError,passwordError)
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    val passwordListener = object : TextWatcher{
        override fun afterTextChanged(editable: Editable?) {
            password = editable.toString()
            Logger.logError("Password OTG",password)
            when {
                password.trim().isEmpty() -> passwordValidator.value = ErrorConstants.EMPTY
                password.trim().length < 8 -> passwordValidator.value = ErrorConstants.LENGTH
                !(password.trim().matches(prdRegex)) -> passwordValidator.value = ErrorConstants.INVALID_PASSWORD
                else -> passwordValidator.value = ErrorConstants.NO_ERROR
            }
            passwordError = passwordValidator.value.toString()
            //checkButtonUIValidation(nameError,emailError,passwordError)
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }


    /**
     * Use of the following checkValidation() method is to verify
     * the error messages on the go after any text changed in
     * either of the fields, and once checked will post the live
     * data value in terms of boolean being received in the activity
     * and changing the background of the button accordingly
     */
    /*private fun checkButtonUIValidation(nameError :String, emailError : String, passwordError : String){
        if(nameError == ErrorConstants.NO_ERROR){
            if(emailError == ErrorConstants.NO_ERROR) {
                buttonValidator.value = passwordError == ErrorConstants.NO_ERROR
            }else buttonValidator.value = false
        }else buttonValidator.value = false
    }*/

    fun makeSignUpCall(name : String,email : String, password : String,
    newsLetter : Int, notifications :Int){
        val signUpCall = SignUpCall()
        signUpCall.postSignUpCall(name = name,email = email, password = password,
        newsletter = newsLetter,notificationsOpted = notifications, mCallback = this)
    }

    // Network Ops
    override fun networkCallResponse(
        result: Boolean,
        apiTag: String,
        responseBody: Response<ResponseBody>
    ) {

    }

    override fun networkFailureResponse(result: Boolean, apiTag: String, throwable: Throwable) {

    }

    // Database Ops
    fun insertInUserDb(name:String,email:String,password: String){
        viewModelScope.launch {
            val data = db.UserDaoInterface().getAll()
            db.UserDaoInterface().insertAll(UserEntity((data.size)+1,name,email,password))
        }

    }

}