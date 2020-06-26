package com.example.smashitvmvvm.networking.services.calls.auth


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

/**
 * Created by karanjeet on 3/12/19
 */
class GooglePlusLoginCall {
    private val apiTag = GooglePlusLoginCall::class.java.simpleName

    fun getGooglePlusCall(authToken:String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getGooglePlusResponse = webServiceInterface.getGooglePlusLogin(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getGooglePlusResponse, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}