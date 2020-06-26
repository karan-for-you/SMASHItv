package com.example.smashitvmvvm.networking.services.calls.auth

import com.example.smashitvmvvm.consants.ApiConstants
import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface
import com.google.gson.JsonObject

/**
 * Created by karanjeet on 26/11/19
 */
class ChangePasswordCall {
    private val apiTag = ChangePasswordCall::class.java.simpleName

    fun postChangePasswordCall(authToken:String, currentPassword:String, password:String, email:String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val jsonObject = prepareJSONData(email,password,currentPassword)
        val postResetPasswordCall = webServiceInterface.postResetPassword(authToken,email,currentPassword,password)
        val commonEnqueueValidator = CommonEnqueueValidator(postResetPasswordCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }

    private fun prepareJSONData(email:String,password:String, current_password:String): JsonObject {
        val loginCall = JsonObject()
        loginCall.addProperty(ApiConstants.EMAIL, email)
        loginCall.addProperty(ApiConstants.PRD, password)
        loginCall.addProperty(ApiConstants.CURRENT_PRD, current_password)
        return loginCall
    }
}