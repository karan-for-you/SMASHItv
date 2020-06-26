package com.example.smashitvmvvm.networking.services.calls.payment


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetPaymentPlans {
    private val apiTag = GetPaymentPlans::class.java.simpleName
    fun getPaymentPlans(authToken : String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getPaymentPlans = webServiceInterface.getPaymentPlans(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getPaymentPlans, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}