package com.example.smashitvmvvm.networking.services.calls.payment


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class GetOrderId {
    private val apiTag:String = GetOrderId::class.java.simpleName
    fun getOrderID(authToken : String,
                   telCode:String,
                   tel:String,
                   subscriptionId:String,
                   email:String,
                   city:String,
                   country:String,
                   state:String,
                   zipCode:String,
                   mCallback: NetworkCallResponse
    ) {
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val getOrderID = webServiceInterface.getOrderId(authToken,
            telCode,
            tel,
            subscriptionId,
            email,
            city,
            country,
            state,
            zipCode)
        val commonEnqueueValidator = CommonEnqueueValidator(getOrderID, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}