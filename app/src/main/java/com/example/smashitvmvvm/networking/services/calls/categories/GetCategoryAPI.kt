package com.example.smashitvmvvm.networking.services.calls.categories


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetCategoryAPI {
    private val apiTag = GetCategoryAPI::class.java.simpleName

    fun getCategoryVODs(authToken: String, queryString: String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv"
        )
        val getCategoryVODs = webServiceInterface.getCategoryVODs(authToken, queryString)
        val commonEnqueueValidator = CommonEnqueueValidator(getCategoryVODs, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}