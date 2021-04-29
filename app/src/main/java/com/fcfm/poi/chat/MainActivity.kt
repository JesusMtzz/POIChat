package com.fcfm.poi.chat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fcfm.poi.chat.modelos.Usuario
import kotlinx.android.synthetic.main.activity_main.*

import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {


    private val database = FirebaseDatabase.getInstance()
    private val chatRef = database.getReference("usuario")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Chat Personal






        btnChatPersonal.setOnClickListener {

            val nombreUsuario = txtUsuario.text.toString()
            //codigo nuevo
            var entrar = false;


            chatRef.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {


                    for (snap in snapshot.children) {

                        val usuario: Usuario = snap.getValue(Usuario::class.java) as Usuario
                        if (usuario.nombre == nombreUsuario)
                            entrar = true;


                        if (nombreUsuario.isEmpty()) {

                            Toast.makeText(this@MainActivity, "Falta usuario", Toast.LENGTH_SHORT).show()
                        } else {
                            if(entrar) {
                                val intentChat = Intent(this@MainActivity, ChatActivity::class.java)
                                intentChat.putExtra("nombreUsuario", nombreUsuario)

                                startActivity(intentChat)
                                entrar = false;
                            } else {

                                Toast.makeText(this@MainActivity, "No es tu chat", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }


                }
                override fun onCancelled(error: DatabaseError) {

                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            })




        }

//Chat Grupal
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