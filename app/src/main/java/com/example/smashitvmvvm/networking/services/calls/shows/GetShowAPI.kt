package com.example.smashitvmvvm.networking.services.calls.shows


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetShowAPI {
    private val apiTag = GetShowAPI::class.java.simpleName

    fun getShow(authToken:String, queryString :String,  mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getShowVOD = webServiceInterface.getShowsVODs(authToken,queryString)
        val commonEnqueueValidator = CommonEnqueueValidator(getShowVOD, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}