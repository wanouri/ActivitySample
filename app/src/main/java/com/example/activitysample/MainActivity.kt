package com.example.activitysample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addText("onCreate")
    }

    override fun onStart() {
        super.onStart()
        addText("onStart")
    }

    override fun onRestart() {
        super.onRestart()

        addText("onRestart")
    }

    override fun onResume() {
        super.onResume()
        addText("onResume")
    }

    override fun onPause() {
        super.onPause()
        addText("onPause")
    }

    override fun onStop() {
        super.onStop()
        addText("onStop")
        val dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
        Log.d(MainActivity::class.java.simpleName,dt.plus(" ").plus("onStop"))
    }

    override fun onDestroy() {
        super.onDestroy()
        val dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
        Log.d(MainActivity::class.java.simpleName,dt.plus(" ").plus("onDestroy"))
    }

    fun addText(s : String) {

        val dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))

        val textView : TextView = findViewById(R.id.textView)

        if (textView.text.isNotEmpty()) {
            textView.text = textView.text.toString().plus("\n").plus(dt).plus(" ").plus(s)
        }
        else
        {
            textView.text = dt.plus(" ").plus(s)
        }
    }

}
