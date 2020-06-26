package com.example.smashitvmvvm.networking.services.calls.home


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetRelatedVODs {
    private val apiTag = GetRelatedVODs::class.java.simpleName
    fun getRelatedVODs(authToken:String, slug : String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getAPIData = webServiceInterface.getSlugRelatedVODs(authToken,slug)
        val commonEnqueueValidator = CommonEnqueueValidator(getAPIData, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}