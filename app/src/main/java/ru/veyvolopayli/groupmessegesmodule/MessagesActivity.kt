package ru.veyvolopayli.groupmessegesmodule

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_messages.*
import org.w3c.dom.Text
import ru.veyvolopayli.groupmessegesmodule.databinding.ActivityMessagesBinding
import kotlin.math.abs

class MessagesActivity : AppCompatActivity() {

    lateinit var binding: ActivityMessagesBinding
    lateinit var adapter: MessageAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initial()
    }

    private fun initial() {
        recyclerView = binding.recyclerViewMessages
        adapter = MessageAdapter(this)
        recyclerView.adapter = adapter
        val open_enter_message_button = findViewById<Button>(R.id.open_enter_message_button)
        open_enter_message_button.setOnClickListener{

        }
        adapter.setList(myMessage())
        val messages_count_tv = findViewById<TextView>(R.id.messages_count_tv)
        messages_count_tv.text = adapter.itemCount.toString()
        val database = Firebase.database
        val myRef = database.getReference("Messages")
        myRef.setValue(myMessage())
    }



    fun myMessage() : ArrayList<MessageModel>{
        val messagesList = ArrayList<MessageModel>()

        /*val message = MessageModel("??????????????, ?????????????? ???? 5 ???????????? ?????????????? ?????? ???????? ???????? ?? ?????????????? ????????????. ?? ???????????????? ???? ????????????????????\n" +
                "???????????? ????????. ?????????????????? ?????? ???????????????????? ???? ???????????? ?? ???????????????????? ?? ???????? ????????????????\n" +
                "\n" +
                "?? 13.15 ?????????????????????????? ???????????????? ?? ????????. ???? ??????????????????????, ????????????????????????\n" +
                "\n" +
                "https://teams.microsoft.com/l/meetup-join/19:8d8a21c6257f4a1cbb78ca91d79183fe@thread.tacv2/1663917742707?context={\"Tid%22:%2298333599-d636-4ea0-8d59-1b9cdeeb83ca\",\"Oid%22:%22f6477578-5506-4cbe-b544-b688039301aa\"}\n" +
                "\n" +
                "?? ??????????????????, ?????????????????? ??.??.\n")
        messagesList.add(message)

        val message1 = MessageModel("??????????????????:\n" +
                "???????????? ????????. ?? ?? ???? ???????????????? ???? ?????????? 2 ??????????. ?????? ?????????? ???????????? ?????????????? ?????????????????????? ???????????? ?????????? ???????????? ?? ????????. ?????????? ?????????????? ???????????? ????????????????, ???????? ???????????????????????????? ??????????. ?????????? ????????, ?? ???????? ???????? ?????? ?????????????? ?????????????????? ?? ????????????????????, ???? ?????? ?????????????????????? ?????????????????????? ???????? ?? ???????????? ???????? ?????????? ?????????????????????? ?? ???????????????????????? ?????????????????? ????????????. ???????????? ???? ?????????????? ??????????????, ?????????? 5-6-7 ??????????????")
        messagesList.add(message1)

        val message2 = MessageModel("????????????. ??????. 9-10, ?????????? 5\n" +
                "???????????? 1.3 (??????. 8)\n" +
                "\n" +
                "???????????? ?????? ????; ??1, ???????????? 5")
        messagesList.add(message2)*/

        return messagesList
    }

}