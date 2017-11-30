package com.rivuchk.todoapplication.apis

import com.rivuchk.todoapplication.apis.apiresponse.BaseAPIResponse
import com.rivuchk.todoapplication.apis.apiresponse.GetToDoListAPIResponse
import com.rivuchk.todoapplication.datamodels.ToDoModel
import com.rivuchk.todoapplication.utils.Constants
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Rivu on 01-11-2017.
 */
interface APIService {
    @POST(Constants.GET_TODO_LIST)
    fun getToDoList(): Observable<GetToDoListAPIResponse>

    @POST(Constants.EDIT_TODO)
    fun editTodo(
            @Body todo:String
    ): Observable<BaseAPIResponse>

    @POST(Constants.ADD_TODO)
    fun addTodo(@Body todo:String): Observable<BaseAPIResponse>
}