package com.rivuchk.todoapplication.apis.apiresponse

import com.google.gson.annotations.SerializedName
import com.rivuchk.todoapplication.datamodels.ToDoModel
import java.io.Serializable

/**
 * Created by Rivu on 01-11-2017.
 */

open class GetToDoListAPIResponse(
        errorCode:Int,
        errorMessage:String,
        val data:ArrayList<ToDoModel>
):BaseAPIResponse(errorCode,errorMessage)