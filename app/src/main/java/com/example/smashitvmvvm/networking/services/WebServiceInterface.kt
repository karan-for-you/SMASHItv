package com.example.smashitvmvvm.networking.services

import com.example.smashitvmvvm.consants.ApiNodes
import com.example.smashitvmvvm.consants.ApiConstants
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by karanjeet on 5/10/19
 */
interface WebServiceInterface {

    @POST(ApiNodes.REGISTER_NODE)
    fun postSignUp(@Body jsonObject: JsonObject): Call<ResponseBody>

    @POST(ApiNodes.LOGIN_NODE)
    fun postLogin(
        @Query(ApiConstants.EMAIL) email: String,
        @Query(ApiConstants.PRD) password: String
    ): Call<ResponseBody>

    @POST(ApiNodes.RESET_PSD_NODE)
    fun postResetPassword(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.EMAIL) email: String,
        @Query(ApiConstants.CURRENT_PRD) current_password: String,
        @Query(ApiConstants.PRD) password: String
    ): Call<ResponseBody>

    @POST(ApiNodes.FORGOT_PSD_NODE)
    fun postForgotPassword(@Query(ApiConstants.EMAIL) email: String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.GOOGLE_LOGIN_NODE)
    fun getGooglePlusLogin(@Query(ApiConstants.CODE) googleAuthCode: String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.FACEBOOK_LOGIN_NODE)
    fun getFacebookLogin(@Query(ApiConstants.CODE) facebookAuthToken: String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.VIDEOS_NODE)
    fun getHomeVODs2(@Header(ApiConstants.AUTHORIZATION) authToken: String): Call<ResponseBody>

    @GET(ApiNodes.SEARCH_NODE)
    fun getSearchedVODs(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.QUERY_STRING) queryString: String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.CATEGORIES_NODE)
    fun getCategoryVODs(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.QUERY_STRING) queryString: String
    ): Call<ResponseBody>

    @GET(ApiNodes.MOST_VIEWED_NODE)
    fun getMostViewVODs(@Header(ApiConstants.AUTHORIZATION) authToken: String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.RELATED_VIDEOS_NODE)
    fun getRelatedVODs(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.QUERY_STRING) id: String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.RELATED_SLUG_VIDEOS_NODE)
    fun getSlugRelatedVODs(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.QUERY_STRING) q: String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.SHOWS_NODE)
    fun getShowsVODs(
        @Header(ApiConstants.AUTHORIZATION) authToken: String,
        @Query(ApiConstants.QUERY_STRING) title: String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.RESET_PSD_MOBILE_NODE)
    fun postChangePassword(
        @Query(ApiConstants.TOKEN) token: String?,
        @Query(ApiConstants.PRD) password: String?
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.USER_NOTIFICATION_NODE)
    fun postFirebaseToken(
        @Header(ApiConstants.AUTHORIZATION) token: String?,
        @Query(ApiConstants.FCM_TOKEN) fcmToken: String?
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.USER_NOTIFICATION_UNREGISTER_NODE)
    fun deleteFirebaseToken(
        @Header(ApiConstants.AUTHORIZATION) token: String?,
        @Query(ApiConstants.FCM_TOKEN) fcmToken: String?
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.NOTIFICATION_STATUS_NODE)
    fun postNotificationsStatus(
        @Header(ApiConstants.AUTHORIZATION) token: String?,
        @Query(ApiConstants.STATUS_CODE) statusCode: Int
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.PAYMENT_INFO)
    fun postPaymentInfo(
        @Header(ApiConstants.AUTHORIZATION) authToken: String?,
        @Query(ApiConstants.ORDER_ID) orderId: String,
        @Query(ApiConstants.MOBILE) mobile: String,
        @Query(ApiConstants.BILLING_ADDRESS) billingAddress: String,
        @Query(ApiConstants.BILLING_CITY) billingCity: String,
        @Query(ApiConstants.BILLING_COUNTRY) billingCountry: String,
        @Query(ApiConstants.BILLING_STATE) billingState: String,
        @Query(ApiConstants.BILLING_ZIP_CODE) billingZipCode: String,
        @Query(ApiConstants.PAYMENT_TOKEN) paymentToken: String,
        @Query(ApiConstants.PLAN_SELECTED) planSelected: String,
        @Query(ApiConstants.AMOUNT) amount: Double,
        @Query(ApiConstants.TAX_AMOUNT) taxAmount: Float,
        @Query(ApiConstants.CURRENCY_CODE) currencyCode: String,
        @Query(ApiConstants.SUBSCRIPTION_ID) subscriptionId: String,
        @Query(ApiConstants.COUPON) coupon: String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.PAYMENT_INFO)
    fun postPaymentInfo2(
        @Header(ApiConstants.AUTHORIZATION) authToken: String?,
        @Query(ApiConstants.PAYMENT_REFERENCE)paymentReference : String,
        @Query(ApiConstants.PT_CUSTOMER_EMAIL)ptCustomerEmail : String,
        @Query(ApiConstants.PT_CUSTOMER_PASSWORD)ptCustomerPassword : String,
        @Query(ApiConstants.PT_TOKEN)ptToken : String
    ): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @GET(ApiNodes.PAYMENT_PLANS)
    fun getPaymentPlans(@Header(ApiConstants.AUTHORIZATION)authToken : String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @POST(ApiNodes.ORDER_ID)
    fun getOrderId(@Header(ApiConstants.AUTHORIZATION)authToken : String,
                   @Query(ApiConstants.TEL_CODE)telCode:String,
                   @Query(ApiConstants.TEL)tel:String,
                   @Query(ApiConstants.SUBSCRIPTION_ID_ORDER_ID)subscriptionId:String,
                   @Query(ApiConstants.EMAIL_ORDER_ID)email:String,
                   @Query(ApiConstants.CITY)city:String,
                   @Query(ApiConstants.COUNTRY)country:String,
                   @Query(ApiConstants.STATE)state:String,
                   @Query(ApiConstants.ZIP_CODE)zipCode:String): Call<ResponseBody>

    @Headers(ApiConstants.ACCEPT_APPLICATION_JSON)
    @DELETE(ApiNodes.UNSUBSCRIBE)
    fun deleteSubscription(@Header(ApiConstants.AUTHORIZATION)authToken: String): Call<ResponseBody>

}