package com.fcfm.poi.chat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChatPersonal.setOnClickListener {

            val nombreUsuario = txtUsuario.text.toString()

            if (nombreUsuario.isEmpty()) {

                Toast.makeText(this, "Falta usuario", Toast.LENGTH_SHORT).show()
            } else {

                val intentChat = Intent(this, ChatActivity::class.java)
                intentChat.putExtra("nombreUsuario", nombreUsuario)

                startActivity(intentChat)
            }
        }


        btnChatGrupal.setOnClickListener {

            val nombreUsuario = txtUsuario.text.toString()

            if (nombreUsuario.isEmpty()) {

                Toast.makeText(this, "Falta usuario", Toast.LENGTH_SHORT).show()
            } else {

                val intentChat = Intent(this, ChatActivityGrupal::class.java)
                intentChat.putExtra("nombreUsuario", nombreUsuario)

                startActivity(intentChat)
            }
        }


    }
}