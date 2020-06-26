package com.example.smashitvmvvm.networking.services.calls.settings


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class PostNotificationsOpted {
    private val apiTag = PostNotificationsOpted::class.java.simpleName

    fun postNotificationsOptedStatus(
        authToken: String,
        statusCode: Int,
        mCallback: NetworkCallResponse
    ) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv"
        )
        val postNotificationsOptedCall =
            webServiceInterface.postNotificationsStatus(authToken, statusCode)
        val commonEnqueueValidator =
            CommonEnqueueValidator(postNotificationsOptedCall, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}