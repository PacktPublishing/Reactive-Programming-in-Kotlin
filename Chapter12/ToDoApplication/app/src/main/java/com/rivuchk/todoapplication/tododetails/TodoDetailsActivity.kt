package com.rivuchk.todoapplication.tododetails

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.DatePicker
import com.google.gson.Gson
import com.jakewharton.rxbinding2.view.clicks
import com.rivuchk.todoapplication.BaseActivity
import com.rivuchk.todoapplication.R
import com.rivuchk.todoapplication.apis.APIClient
import com.rivuchk.todoapplication.datamodels.ToDoModel
import com.rivuchk.todoapplication.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_todo_details.*
import kotlinx.android.synthetic.main.content_todo_details.*
import org.jetbrains.anko.imageBitmap
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import java.util.*

class TodoDetailsActivity : BaseActivity() {
    override fun onCreateBaseActivity(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_todo_details)
        toolbar.title = "View and Edit TODO"
        setSupportActionBar(toolbar)

        todoDataModel = intent?.getSerializableExtra(Constants.INTENT_TODOITEM) as? ToDoModel

        txtID.text = todoDataModel?.id?.toString()
        txtDesc.setText(todoDataModel?.todoDescription)
        txtStatus.setText(todoDataModel?.status)
        txtDate.text = todoDataModel?.todoTargetDate

        fabEditTodo.clicks().subscribeBy { _ ->
            if(isEditing) {
                saveData()
            } else {
                startEdit()
            }
        }
    }

    var todoDataModel:ToDoModel? = null
    var isEditing = false



    private fun saveData() {

        todoDataModel?.todoDescription = txtDesc.text.toString()
        todoDataModel?.status = txtStatus.text.toString()
        todoDataModel?.todoTargetDate = txtDate.text.toString()

        val gson = Gson()
        val jsonTodo = gson.toJson(todoDataModel)
        APIClient()
                .getAPIService()
                .editTodo(todoDataModel?.id?.toString()?:"",
                        jsonTodo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    response->
                    if(response.errorCode == 0) {
                        stopEdit()
                        toast("Todo successfully saved")
                        setResult(Activity.RESULT_OK)
                    } else {
                        toast("Couldn't save Todo, please try again")
                    }
                }
    }

    private fun startEdit() {
        isEditing = true
        txtDesc.inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE or InputType.TYPE_CLASS_TEXT
        txtStatus.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS or InputType.TYPE_CLASS_TEXT

        txtDate.onClick {
            val calendar = Calendar.getInstance()
            val dp = DatePickerDialog(this@TodoDetailsActivity,
                    DatePickerDialog.OnDateSetListener {
                        _, year, month, dayOfMonth ->
                        txtDate.text = "$year/${month+1}/$dayOfMonth"
                    }
                    ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
            dp.show()
        }

        txtDesc.requestFocus()

        fabEditTodo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_save))
    }

    override fun onBackPressed() {
        if(!isEditing) {
            super.onBackPressed()
        } else {
            stopEdit()
        }
    }

    private fun stopEdit() {
        isEditing = false
        txtDesc.inputType = InputType.TYPE_NULL or InputType.TYPE_CLASS_TEXT
        txtStatus.inputType = InputType.TYPE_NULL

        txtDate.onClick{}
        fabEditTodo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_edit))
    }
}
