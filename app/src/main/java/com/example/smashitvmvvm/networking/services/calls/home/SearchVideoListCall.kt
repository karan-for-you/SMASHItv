package com.example.smashitvmvvm.networking.services.calls.home


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class SearchVideoListCall {
    private val apiTag = SearchVideoListCall::class.java.simpleName
    fun getSearchVideosList(authToken : String, queryText : String,  mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getSearchVODsAPIData = webServiceInterface.getSearchedVODs(authToken,queryText)
        val commonEnqueueValidator = CommonEnqueueValidator(getSearchVODsAPIData, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}