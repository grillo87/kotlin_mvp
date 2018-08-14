package com.josegrillo.kotlinmvp.utils

import java.util.regex.Pattern

class AppConstants {

    companion object {

        val APP_DB_NAME = "kotlinmvp_grillo.db"
        val BASE_URL = "http://private-8cffd-kotlinmvp.apiary-mock.com/"
        val HEADER_CONTENT_TYPE_TAG = "Content-Type"
        val HEADER_ACCEPT_TAG = "Accept"
        val HEADER_APPLICATION_JSON_TAG = "application/json"
        val REQUEST_TAG = "Request"
        val RESPONSE_TAG = "Response"
        val EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")")

    }

}