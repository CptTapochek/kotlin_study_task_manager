package com.example.task_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_of_tasks)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.add_button)

        val tasks: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, index, lenght ->
            val text: String = listView.getItemAtPosition(index).toString()
            adapter.remove(text)
            Toast.makeText(this, "Task $text has been removed", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if(text != "") {
                adapter.insert(text, 0)
                Toast.makeText(this, "Task $text has been added", Toast.LENGTH_SHORT).show()
            }
        }
    }
}