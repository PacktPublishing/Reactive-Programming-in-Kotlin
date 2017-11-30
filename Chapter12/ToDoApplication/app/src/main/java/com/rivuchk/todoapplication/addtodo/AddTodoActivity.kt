package com.rivuchk.todoapplication.addtodo

import android.app.Activity
import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.rivuchk.todoapplication.BaseActivity
import com.rivuchk.todoapplication.R
import com.rivuchk.todoapplication.apis.APIClient
import com.rivuchk.todoapplication.datamodels.ToDoModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_todo.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import java.util.*

class AddTodoActivity : BaseActivity() {
    override fun onCreateBaseActivity(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_add_todo)

        txtDate.onClick {
            val calendar = Calendar.getInstance()
            val dp = DatePickerDialog(this@AddTodoActivity,
                    DatePickerDialog.OnDateSetListener {
                        _, year, month, dayOfMonth ->
                        txtDate.text = "$year/${month+1}/$dayOfMonth"
                    }
                    ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
            dp.datePicker.minDate = calendar.timeInMillis
            dp.show()
        }

        btnAddTodo.onClick {
            val desc = txtDesc.text.toString()
            val date = txtDate.text.toString()
            val status = txtStatus.text.toString()
            if(desc.isBlank() || date.isBlank()) {
                longToast("Todo Description and Date are Mandatory")
            } else {
                val todoDataModel = ToDoModel(0,desc,date,status)
                val gson = Gson()
                val jsonTodo = gson.toJson(todoDataModel)
                APIClient()
                        .getAPIService()
                        .addTodo(jsonTodo)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy {
                            response->
                            if(response.errorCode == 0) {
                                toast("Todo successfully saved")
                                setResult(Activity.RESULT_OK)
                                finish()
                            } else {
                                toast("Couldn't save Todo, please try again")
                            }
                        }
            }
        }


    }


}
