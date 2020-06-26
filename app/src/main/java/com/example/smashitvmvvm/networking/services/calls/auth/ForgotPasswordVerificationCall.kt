package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class ForgotPasswordVerificationCall {
    private val apiTag = ForgotPasswordVerificationCall::class.java.simpleName

    fun postForogtPasswordVerificationCall(token : String?, password:String?, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val postForgotPasswordCall = webServiceInterface.postChangePassword(token,password)
        val commonEnqueueValidator = CommonEnqueueValidator(postForgotPasswordCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}