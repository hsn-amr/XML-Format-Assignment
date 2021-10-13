package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVStudentDetails
    lateinit var rvMain: RecyclerView

    lateinit var students: List<StudentDetails>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val parser = MyXmlPullParser()
            val iStream = assets.open("StudentDetails.xml")
            students = parser.parse(iStream)
        }catch (e: IOException){
            e.printStackTrace()
        }
        rvMain = findViewById(R.id.rvMain)

        adapter = RVStudentDetails(students)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)
    }
}