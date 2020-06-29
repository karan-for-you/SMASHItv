package com.example.smashitvmvvm.consants

import com.google.android.gms.wallet.WalletConstants

object Constants {
    // Fragment Tags

    //const val HOME_FRAGMENT = "HOME_FRAGMENT"
    //const val SEARCH_FRAGMENT = "SEARCH_FRAGMENT"
    //const val ACCOUNT_FRAGMENT = "ACCOUNT_FRAGMENT"
    //const val SETTINGS_FRAGMENT = "SETTINGS_FRAGMENT"

    const val HOME_FRAGMENT_VAL = "1"
    const val SEARCH_FRAGMENT_VAL = "2"
    const val ACCOUNT_FRAGMENT_VAL = "3"
    const val SETTINGS_FRAGMENT_VAL = "4"
    const val CATEGORIES_FRAGMENT_VAL = "5"
    const val SHOWS_FRAGMENT_VAL = "6"
    const val SELECTED_VOD_FRAGMENT_VAL = "-1"

    const val EXIT_INTERVAL = 3000
    const val ITEM_VIEW_CACHE = 1000
    const val SPAN_COUNT = 2
    const val SEARCH_DELAY : Long = 1000L
    const val VIEW_BAR_FACTOR : Long = 20

    const val UNAUTHORIZED = 401
    const val MESSAGE = "message"
    const val STATUS = "status"

    const val FACEBOOK_METHOD = "FACEBOOK"
    const val GPLUS_METHOD = "G+"
    const val NORMAL = "NORMAL"

    const val PAYMENTS_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST
    const val gatewayMerchantId = "10036326"

    const val NO_DAYS_ACCOUNTED_RATING_DIALOG = 3
    const val NO_DAYS_ACCOUNTED_TRIAL_EXPIRED = 7

    const val ANDROID_SCREEN_TRACKING_VIEW = "android_screen_tracking_view"
    const val SCREEN_NAME = "screen_name"

    val SUPPORTED_NETWORKS = listOf(
        "AMEX",
        "DISCOVER",
        "JCB",
        "MASTERCARD",
        "VISA"
    )

    val SUPPORTED_METHODS = listOf(
        "PAN_ONLY",
        "CRYPTOGRAM_3DS"
    )

    const val CURRENCY_CODE = "AED"

    private const val PAYMENT_GATEWAY_TOKENIZATION_NAME = "SMASHItv"

    val PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS = mapOf(
        "gateway" to PAYMENT_GATEWAY_TOKENIZATION_NAME,
        gatewayMerchantId to "exampleGatewayMerchantId"
    )

    // PayTabs Test Details
    const val TEST_MERCHANT = "vishal.yadav@oodlestechnologies.com"
    const val TEST_TOKEN = "8HdTuU2gfJjBBaZyUlRyugRXje2GqUAzCNt6IvmXfGzQQyoKTfiovalPoovPi5pVTS1BoozD48tUGSFA8YYE8kuxIZn15NWYFYz3"

    // PayTabs Details
    const val DIRECT_TOKENIZATION_PUBLIC_KEY =
        "CL1YngD00P5Z3Fttz5Cvm5BR6Q8UDU2gG3e3jS3jH8jKOMdnRQTeVv52ldWZ8YfO2uRlmVF33YORK1fCS9RNEXQZaMYjLd7NHZ94"
    const val MERCHANT_ID = "10036326"
    const val MERCHANT_EMAIL = "rich@weareaugustus.com"

    val DIRECT_TOKENIZATION_PARAMETERS = mapOf(
        "protocolVersion" to "ECv1",
        "publicKey" to DIRECT_TOKENIZATION_PUBLIC_KEY
    )

    const val CATEGORY_DELIVERED = "CATEGORY"
    const val SHOWS_DELIVERED = "SHOW"
    const val MOST_VIEWED_CATEGORY = "mostViewed"
    const val BUSINESS_CATEGORY = "business"
    const val TECH_CATEGORY = "tech"
    const val LIFESTYLE_CATEGORY = "lifestyle"

    const val AED = "AED"
    const val USD = "USD"
    const val SAR = "SAR"

    val currenciesAccepted = arrayOf("AED", "USD", "SAR")

    const val PLAN_SELECTED = "planSelected"

    const val DOLLAR_SIGN = "$"
    const val AED_SIGN = "د.إ"
    const val SAR_SIGN = "ر.س"

    const val LATEST = "latest"
    const val BUSINESS = "business"
    const val TECH = "tech"
    const val LIFESTYLE = "lifestyle"

    const val PRD_REGEX =
        "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[$&.+,:;=?@#|'<>^*()%!-]).{8,64})"

    const val EMAIL_REGEX =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[\$&+,:;=?@#|'<>-^*()%!]]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})\$"

    const val NUMBER_REGEX = ".*\\d.*"
    const val SPECIAL_CHAR_REGEX = "[\$&+,:;=?@#|'<>^*()%!-]"


}
