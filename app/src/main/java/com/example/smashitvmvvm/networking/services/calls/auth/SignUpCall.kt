package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.consants.ApiConstants
import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface
import com.google.gson.JsonObject

/**
 * Created by karanjeet on 5/11/19
 */
class SignUpCall {
    private val apiTag = SignUpCall::class.java.simpleName

    fun postSignUpCall(name:String, email:String, password:String, newsletter : Int,
                       notificationsOpted: Int, mCallback: NetworkCallResponse
    ) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val jsonObject = prepareJSONData(name,email,password,newsletter,notificationsOpted)
        val postSignUpCall = webServiceInterface.postSignUp(jsonObject)
        val commonEnqueueValidator = CommonEnqueueValidator(postSignUpCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }

    private fun prepareJSONData(name:String,email:String,password:String,newsletter:Int,notificationsOpted : Int):JsonObject{
        val signUpJson = JsonObject()
        signUpJson.addProperty(ApiConstants.NAME, name)
        signUpJson.addProperty(ApiConstants.EMAIL, email)
        signUpJson.addProperty(ApiConstants.PRD, password)
        signUpJson.addProperty(ApiConstants.NEWSLETTER, newsletter)
        signUpJson.addProperty(ApiConstants.NOTIFICATIONS_OPTED, notificationsOpted)
        return signUpJson
    }

}