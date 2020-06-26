package com.example.smashitvmvvm.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.smashitvmvvm.consants.Constants
import com.example.smashitvmvvm.sessionprefs.SessionPreferences
import com.example.smashitvmvvm.utils.Network
import com.example.smashitvmvvm.utils.UI
import com.example.smashitvmvvm.ui.activities.SplashActivity
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

/**
 * Created by karanjeet on 22/10/19
 */
abstract class BaseActivity : AppCompatActivity(), MvpView {

    var sessionPreferences : SessionPreferences? = null
    private var progressBar : AlertDialog? = null
    var PERMISSION_CALLBACK_RESULT = 110

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        sessionPreferences = SessionPreferences(this)
    }

    override fun showToast(message : String) {
        UI.showToast(message,this,false)?.show()
    }

    override fun showToast(resId: Int) {
        UI.showToast(resId,this,false)?.show()
    }

    override fun showLongToast(message: String) {
        UI.showLongToast(message,this,false)?.show()
    }

    override fun showLongToast(resId: Int) {
        UI.showLongToast(resId,this,false)?.show()
    }

    override fun showProgressBar() {
        progressBar = UI.showSmashiProgressBar(this)
        progressBar!!.show()
    }

    override fun showProgressBar(message : String) {
        progressBar = UI.showProgressBar(this,message)
        progressBar!!.show()
    }

    override fun showProgressBar(resId: Int) {
        progressBar = UI.showProgressBar(this,resId)
        progressBar!!.show()
    }

    override fun hideProgressBar() {
        if(progressBar!=null && progressBar!!.isShowing){
            progressBar!!.cancel()
        }
    }

    override fun isNetworkConnected():Boolean {
        return Network.isNetworkAvailable(this)
    }

    override fun showKeyboard() {
        UI.showSoftKeyboard(this)
    }

    override fun hideKeyboard() {
        UI.hideSoftKeyboard(this)
    }

    @Throws(JSONException::class ,IOException::class)
    fun handleErrorMessage(responseBody : Response<ResponseBody>)  {
        val resultString = responseBody.errorBody()!!.string()
        val jsonObject = JSONObject(resultString)
        val message = jsonObject.getString(Constants.MESSAGE)
        showToast(message)
        if (jsonObject.getInt(Constants.STATUS) == Constants.UNAUTHORIZED)
            showLongToast(message)
    }

    override fun showNativeDialog(messageTitle: String, messageContent: String) {

    }

    override fun performLogout() {
        val intent = Intent(applicationContext, SplashActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        sessionPreferences?.clearSession()
        startActivity(intent)
        finish()
    }

}