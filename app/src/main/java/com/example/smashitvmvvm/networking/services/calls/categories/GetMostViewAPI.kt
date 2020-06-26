package com.example.smashitvmvvm.networking.services.calls.categories


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetMostViewAPI {
    private val apiTag = GetMostViewAPI::class.java.simpleName

    fun getMostViewCategoryVODs(authToken:String,  mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getMostViewVODs = webServiceInterface.getMostViewVODs(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getMostViewVODs, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}