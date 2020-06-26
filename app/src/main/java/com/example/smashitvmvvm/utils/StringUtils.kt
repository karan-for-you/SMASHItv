package com.example.smashitvmvvm.utils

import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.ui.base.BaseActivity

import java.util.*

/**
 * Created by karanjeet on 20/11/19
 */
class StringUtils {

    companion object{

    fun isNullOrEmpty(pStr: String?): Boolean {
        return pStr == null || pStr.trim { it <= ' ' }.isEmpty() || pStr.trim { it <= ' ' }.equals(
            "null",
            ignoreCase = true
        ) || "" == pStr
    }

    fun isNullOrEmptyOrZero(pStr: String?): Boolean {
        return pStr == null || pStr.trim { it <= ' ' }.isEmpty() || pStr.trim { it <= ' ' }.equals(
            "null",
            ignoreCase = true
        ) || pStr.trim { it <= ' ' }.equals("0", ignoreCase = true)
    }

    /**
     * Method returns the index of in the string where the stringToFind
     * starts in the fullString
     * @param stringToFind - Target string to find
     * @param fullString - The full string in which strings is to be found
     * @return
     */
    private fun isSubstring(stringToFind: String, fullString: String): Int {
        val m = stringToFind.length
        val n = fullString.length

        for (i in 0..n - m) {
            var j = 0
            while (j < m) {
                if (fullString[i + j] != stringToFind[j])
                    break
                j++
            }
            if (j == m)
                return i
        }

        return -1
    }

    fun createSpannableStringBuilder(
        fullString: String,
        stringToFind: String,
        color: Int,
        context: Context
    ): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        val ss = SpannableString(fullString)
        val startIndex = isSubstring(stringToFind, fullString)
        // Adding the startIndex to the length of stringToFind
        // so that entire word found is marked
        ss.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, color)),
            startIndex,
            startIndex + stringToFind.length,
            0
        )
        builder.append(ss)
        return builder
    }

        fun checkEditTexts(eds: ArrayList<EditText>, baseActivity: BaseActivity): Boolean {
            for (ed in eds) {
                if (ed.text.isEmpty()) {
                    baseActivity.showToast("" + ed.hint + " لا يمكن أن تكون فارغة ")
                    return false
                }
            }
            return true
        }

        /**
         * Used in Edit Account Activity to avoid the nesting of the logic with-in
         */
        fun validateChangeOfPasswordFields(oldPassword : String?, newPassword : String?,
                                           confirmNewPassword : String?, activity : BaseActivity?) : Boolean{
            if(oldPassword == newPassword) {
                activity?.showToast(activity.resources.getString(R.string.new_old_password_same))
                return false
            }
            if(newPassword!!.length <= 8) {
                activity?.showToast(activity.resources.getString(R.string.password_must_be_8))
                return false
            }
            if(newPassword != confirmNewPassword) {
                activity?.showToast(activity.resources.getString(R.string.new_password_mismatch))
                return false
            }
            return true
        }

        fun validatePaymentForm( mobileNo : String, addressLine: String, state : String,
                                city : String, country : String, activity: BaseActivity?): Boolean?{

            if(mobileNo.isBlank()){
                activity?.showToast("لا يمكن أن يكون حقل الجوال فارغًا")
                return false
            }
            if(addressLine.isBlank()){
                activity?.showToast("لا يمكن ترك حقل العنوان فارغًا")
                return false
            }
            if(state.isBlank()){
                activity?.showToast("لا يمكن ترك حقل المنطقة فارغًاا")
                return false
            }
            if(city.isBlank()){
                activity?.showToast("لا يمكن ترك حقل المدينة فارغًا")
                return false
            }
            if(country == "حدد البلد"){
                activity?.showToast("رجاء قم بإختيار دوله")
                return false
            }
            return true
        }


    }

}