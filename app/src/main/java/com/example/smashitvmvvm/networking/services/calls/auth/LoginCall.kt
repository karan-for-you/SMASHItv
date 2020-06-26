package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

/**
 * Created by karanjeet on 5/11/19
 */
class LoginCall {
    private val apiTag = LoginCall::class.java.simpleName

    fun postLoginCall(email:String, password:String,mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val postLoginCall = webServiceInterface.postLogin(email,password)
        val commonEnqueueValidator = CommonEnqueueValidator(postLoginCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}