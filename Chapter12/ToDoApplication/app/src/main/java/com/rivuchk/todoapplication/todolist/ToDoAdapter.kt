package com.rivuchk.todoapplication.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.view.clicks
import com.rivuchk.todoapplication.R
import com.rivuchk.todoapplication.datamodels.ToDoModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.item_todo.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Rivu on 03-11-2017.
 */
class ToDoAdapter(
        private val context:Context, //(1)
        val onClickTodoSubject:Subject<Pair<View,ToDoModel?>>//(2)
):RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    private val inflater:LayoutInflater = LayoutInflater.from(context)//(3)
    private val todoList:ArrayList<ToDoModel> = arrayListOf()//(4)

    fun setDataset(list:List<ToDoModel>) {//(5)
        todoList.clear()
        todoList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: ToDoViewHolder?, position: Int) {
        holder?.bindView(todoList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(inflater.inflate(R.layout.item_todo,parent,false))
    }

    inner class ToDoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindView(todoItem:ToDoModel?) {
            with(itemView) {//(6)
                txtID.text = todoItem?.id?.toString()
                txtDesc.text = todoItem?.todoDescription
                txtStatus.text = todoItem?.status
                txtDate.text = todoItem?.todoTargetDate

                itemView.clicks()
                        .subscribeBy {
                            onClickTodoSubject.onNext(Pair(itemView,todoItem))
                        }
            }
        }
    }
}