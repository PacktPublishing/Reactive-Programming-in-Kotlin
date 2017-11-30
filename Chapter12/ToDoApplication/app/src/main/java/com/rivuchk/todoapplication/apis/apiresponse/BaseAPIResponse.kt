package com.rivuchk.todoapplication.apis.apiresponse

import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.io.Serializable

/**
 * Created by Rivu on 01-11-2017.
 */

open class BaseAPIResponse (
        @SerializedName("error_code")
        val errorCode:Int,
        @SerializedName("error_message")
        val errorMessage:String): Serializable