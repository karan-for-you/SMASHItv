package com.example.smashitvmvvm.sessionprefs

import android.content.Context
import android.content.SharedPreferences
import android.annotation.SuppressLint


/**
 * Created by karanjeet on 18/10/19
 */
class SessionPreferences(val context : Context) {

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var mPreferences: SessionPreferences? = null
        fun getInstance(context: Context): SessionPreferences {
            if (mPreferences == null) {
                mPreferences = SessionPreferences(context)
            }
            return mPreferences as SessionPreferences
        }
    }

    private var sessionPreferences : SharedPreferences? = null
    private var sessionPreferencesEditor : SharedPreferences.Editor? = null

    init{
        sessionPreferences = context.getSharedPreferences(PrefAttributes.SESSION_PREFS, Context.MODE_PRIVATE)
    }

    /**
     * Bulk Clear of Session Preferences
     */

    @SuppressLint("CommitPrefEdits")
    fun clearSession() {
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.clear()
        sessionPreferencesEditor?.apply()
    }

    /**
     * Saving and serving of data in the local
     * Session Preferences. Please do add new
     * preferences and properties in order to
     * save data according to data
     */

    @SuppressLint("CommitPrefEdits")
    fun setUserId(userId : String){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.USER_ID,userId)
        sessionPreferencesEditor?.apply()
    }

    fun getUserId(): String? {
        return sessionPreferences?.getString(PrefAttributes.USER_ID,"")
    }

    @SuppressLint("CommitPrefEdits")
    fun setUsername(username : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.NAME,username)
        sessionPreferencesEditor?.apply()
    }

    fun getUsername(): String? {
        return sessionPreferences?.getString(PrefAttributes.NAME,"")
    }

    fun setFirstName(firstName : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.FIRST_NAME,firstName)
        sessionPreferencesEditor?.apply()
    }

    fun getFirstName(): String? {
        return sessionPreferences?.getString(PrefAttributes.FIRST_NAME,"")
    }

    fun setLastName(lastName : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.LAST_NAME,lastName)
        sessionPreferencesEditor?.apply()
    }

    fun getLastName(): String? {
        return sessionPreferences?.getString(PrefAttributes.LAST_NAME,"")
    }

    fun setLoginMethod(loginMethod : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.LOGIN_METHOD,loginMethod)
        sessionPreferencesEditor?.apply()
    }

    fun getLoginMethod():String?{
        return sessionPreferences?.getString(PrefAttributes.LOGIN_METHOD,"")
    }

    fun setImageUrl(imageUrl : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.PICTURE_URL,imageUrl)
        sessionPreferencesEditor?.apply()
    }

    fun getImageUrl():String?{
        return sessionPreferences?.getString(PrefAttributes.PICTURE_URL,"")
    }

    fun setEmail(email : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.EMAIL,email)
        sessionPreferencesEditor?.apply()
    }

    fun getEmail():String?{
        return sessionPreferences?.getString(PrefAttributes.EMAIL,"")
    }

    fun setAuthToken(authToken : String?){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.AUTH_TOKEN,authToken)
        sessionPreferencesEditor?.apply()
    }

    fun getAuthToken():String?{
        return sessionPreferences?.getString(PrefAttributes.AUTH_TOKEN,"")
    }

    fun setDateLaunch(dateLaunch : Long){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putLong(PrefAttributes.DATE_LAUNCH,dateLaunch)
        sessionPreferencesEditor?.apply()
    }

    fun getDateLaunch() : Long?{
        return sessionPreferences?.getLong(PrefAttributes.DATE_LAUNCH,0L)
    }

    fun setDateLaunchTrial(dateLaunchTrail : Long){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putLong(PrefAttributes.DATE_LAUNCH_TRIAL,dateLaunchTrail)
        sessionPreferencesEditor?.apply()
    }

    fun getDateLaunchTrail() : Long?{
        return sessionPreferences?.getLong(PrefAttributes.DATE_LAUNCH_TRIAL,0L)
    }

    fun setRatingDialogFlag(flag : Boolean){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putBoolean(PrefAttributes.RATING_DIALOG_FLAG,flag)
        sessionPreferencesEditor?.apply()
    }

    fun getRatingDialogFlag() : Boolean?{
        return sessionPreferences?.getBoolean(PrefAttributes.RATING_DIALOG_FLAG,false)
    }

    fun setFirebaseToken(fcmToken : String){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putString(PrefAttributes.FIREBASE_TOKEN,fcmToken)
        sessionPreferencesEditor?.apply()
    }

    fun getFirebaseToken() : String?{
        return sessionPreferences?.getString(PrefAttributes.FIREBASE_TOKEN,"")
    }

    fun setNotificationsOpted(flag : Int){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putInt(PrefAttributes.NOTIFICATIONS_OPTED,flag)
        sessionPreferencesEditor?.apply()
    }

    fun getNotificationOpted() : Int?{
        return sessionPreferences?.getInt(PrefAttributes.NOTIFICATIONS_OPTED,0)
    }

    fun setIsSubscribed(flag : Boolean){
        sessionPreferencesEditor = sessionPreferences?.edit()
        sessionPreferencesEditor?.putBoolean(PrefAttributes.IS_SUBSCRIBED,flag)
        sessionPreferencesEditor?.apply()
    }

    fun getIsSubscribed(): Boolean?{
        return sessionPreferences?.getBoolean(PrefAttributes.IS_SUBSCRIBED,true)
    }

}