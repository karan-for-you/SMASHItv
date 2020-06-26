package com.example.smashitvmvvm.networking.services.calls.payment


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class PostPaymentInfo {
    private val apiTag = PostPaymentInfo::class.java.simpleName

    fun postPaymentInfo(authToken : String?,
                        orderId : String,
                        mobile : String,
                        billingAddress : String,
                        billingCity : String,
                        billingCountry : String,
                        billingState : String,
                        billingZipCode : String,
                        token : String,
                        planSelected : String,
                        amount : Double,
                        taxAmount : Float,
                        currencyCode : String,
                        subscriptionId : String,
                        coupon : String,
                        mCallback: NetworkCallResponse
    ){
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val postPaymentData =
            webServiceInterface.postPaymentInfo(authToken,
                orderId,mobile,billingAddress,billingCity,
                billingCountry,billingState,billingZipCode,token,
                planSelected,amount, taxAmount, currencyCode,subscriptionId,coupon)
        val commonEnqueueValidator = CommonEnqueueValidator(postPaymentData, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}