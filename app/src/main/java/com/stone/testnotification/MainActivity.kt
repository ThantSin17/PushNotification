package com.stone.testnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var textView=findViewById<TextView>(R.id.text)
        val data=intent.extras
        Log.i("data", data?.getString("data").toString())
        textView.text=data?.getString("data")
        Toast.makeText(this,data?.getString("data"),Toast.LENGTH_SHORT).show()




        //get token
        FirebaseMessaging.getInstance().token.addOnCompleteListener {task->
            if (!task.isSuccessful){
                Log.i("token:","Fail")
            }
            Log.i("token:",task.result.toString())

        }
    }
}