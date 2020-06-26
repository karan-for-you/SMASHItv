package com.example.smashitvmvvm.networking.services.calls.firebase


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class DeleteFirebaseToken {
    private val apiTag = DeleteFirebaseToken::class.java.simpleName

    fun deleteFirebaseToken(fcmToken : String? ,authToken : String?,mCallback: NetworkCallResponse){
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getCategoryVODs = webServiceInterface.deleteFirebaseToken(authToken,fcmToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getCategoryVODs, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}