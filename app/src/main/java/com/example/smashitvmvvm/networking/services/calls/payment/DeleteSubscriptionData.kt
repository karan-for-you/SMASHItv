package com.example.smashitvmvvm.networking.services.calls.payment


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class DeleteSubscriptionData {
    private val apiTag = DeleteSubscriptionData::class.java.simpleName
    fun deleteSubData(authToken : String, mCallback: NetworkCallResponse) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getPaymentPlans = webServiceInterface.deleteSubscription(authToken)
        val commonEnqueueValidator = CommonEnqueueValidator(getPaymentPlans, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}