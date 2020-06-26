package com.example.smashitvmvvm.networking.services.calls.firebase


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class PostFirebaseToken {

    private val apiTag = PostFirebaseToken::class.java.simpleName

    fun postFirebaseToken(authToken : String?, fcmToken : String?,mCallback: NetworkCallResponse){
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getCategoryVODs = webServiceInterface.postFirebaseToken(authToken,fcmToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getCategoryVODs, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}