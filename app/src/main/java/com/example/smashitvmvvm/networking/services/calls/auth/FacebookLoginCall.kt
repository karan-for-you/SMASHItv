package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class FacebookLoginCall {
    private val apiTag = FacebookLoginCall::class.java.simpleName

    fun getFacebookCall(authToken:String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getFacebookResponse = webServiceInterface.getFacebookLogin(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getFacebookResponse, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}