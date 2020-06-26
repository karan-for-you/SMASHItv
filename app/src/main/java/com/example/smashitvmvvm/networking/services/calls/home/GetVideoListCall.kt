package com.example.smashitvmvvm.networking.services.calls.home


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

/**
 * Created by karanjeet on 5/11/19
 */
class GetVideoListCall {
    private val apiTag = GetVideoListCall::class.java.simpleName
    fun getVideosList(authToken : String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getAPIData = webServiceInterface.getHomeVODs2(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getAPIData, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}