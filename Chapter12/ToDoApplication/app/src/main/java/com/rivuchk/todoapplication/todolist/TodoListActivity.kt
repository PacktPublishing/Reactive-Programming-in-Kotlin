package com.rivuchk.todoapplication.todolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import com.rivuchk.todoapplication.BaseActivity
import com.rivuchk.todoapplication.R
import com.rivuchk.todoapplication.addtodo.AddTodoActivity
import com.rivuchk.todoapplication.apis.APIClient
import com.rivuchk.todoapplication.datamodels.ToDoModel
import com.rivuchk.todoapplication.tododetails.TodoDetailsActivity
import com.rivuchk.todoapplication.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

import kotlinx.android.synthetic.main.activity_todo_list.*
import org.jetbrains.anko.intentFor

class TodoListActivity : BaseActivity() {

    lateinit var adapter: ToDoAdapter

    private val INTENT_EDIT_TODO: Int = 100

    private val INTENT_ADD_TODO: Int = 101

    override fun onCreateBaseActivity(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_todo_list)
        setSupportActionBar(toolbar)


        fabAddTodo.clicks().subscribeBy {
            startActivityForResult(intentFor<AddTodoActivity>(),INTENT_ADD_TODO)
        }

        val onClickTodoSubject= PublishSubject.create<Pair<View, ToDoModel?>>()
        onClickTodoSubject.filter{
            it.second != null
        }.subscribeBy {
            startActivityForResult(intentFor<TodoDetailsActivity>(Pair(Constants.INTENT_TODOITEM,it.second)),INTENT_EDIT_TODO)
        }

        adapter = ToDoAdapter(this,onClickTodoSubject)
        rvToDoList.adapter = adapter

        fetchTodoList()
    }

    private fun fetchTodoList() {
        APIClient()
                .getAPIService()
                .getToDoList()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { response ->
                            adapter.setDataset(response.data)
                        },
                        onError = {
                            e-> e.printStackTrace()
                        }
                )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if((requestCode == INTENT_EDIT_TODO || requestCode == INTENT_ADD_TODO) && resultCode == Activity.RESULT_OK) {
            fetchTodoList()
        }
    }
}
