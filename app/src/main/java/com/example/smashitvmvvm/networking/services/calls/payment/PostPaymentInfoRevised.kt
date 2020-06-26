package com.example.smashitvmvvm.networking.services.calls.payment


import com.example.smashitvmvvm.networking.services.CommonEnqueueValidator
import com.example.smashitvmvvm.networking.services.NetworkCallResponse
import com.example.smashitvmvvm.networking.services.ServiceBuilder
import com.example.smashitvmvvm.networking.services.WebServiceInterface

class PostPaymentInfoRevised {
    private val apiTag = PostPaymentInfoRevised::class.java.simpleName

    fun postPaymentInfo(authToken : String?,
                        paymentReference:String,
                        customerEmail:String,
                        customerPassword:String,
                        ptToken:String,
                        mCallback: NetworkCallResponse
    ){
        val webServiceInterface : WebServiceInterface = ServiceBuilder().buildClient(
            WebServiceInterface::class.java,
            "https://www.smashi.tv")
        val postPaymentData =
            webServiceInterface.postPaymentInfo2(authToken,
                paymentReference,customerEmail,customerPassword,ptToken)
        val commonEnqueueValidator = CommonEnqueueValidator(postPaymentData, mCallback, apiTag)
        commonEnqueueValidator.enqueue()
    }
}