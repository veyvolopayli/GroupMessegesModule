package ru.veyvolopayli.groupmessegesmodule

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message_layout.view.*

class MessageAdapter(private val context: Context) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private var messagesList = emptyList<MessageModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_layout, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.itemView.message_tv.text = messagesList[position].message

        holder.itemView.setOnClickListener{
            Toast.makeText(context, (position + 1).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<MessageModel>) {
        messagesList = list
        notifyDataSetChanged()
    }



}