package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class ForgotPasswordCall {
    private val apiTag = ForgotPasswordCall::class.java.simpleName

    fun postForgotPasswordCall(email:String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val postForgotPasswordCall = webServiceInterface.postForgotPassword(email)
        val commonEnqueueValidator = CommonEnqueueValidator(postForgotPasswordCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }

}