package com.fdev.recycleviewcardexample

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log

import com.fdev.recycleviewcard.RecycleViewCard
import com.fdev.recycleviewcard.model.RecycleViewCardFieldsModel

import java.util.ArrayList

data class SampleData(var id: Int, var name: String, var secondName: String, var ava: Bitmap?, var descr: String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rvc = findViewById<RecycleViewCard>(R.id.recycle_view_card)


        val mData = ArrayList<SampleData>()
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))
        mData.add(SampleData(0, "Username 1", "Second name", null, "InfoInfo 1"))


        rvc.setData(RecycleViewCardFieldsModel(
                id = "id",
                avatar = "ava",
                username = "name",
                description = "secondName",
                info = "descr"
        ), mData)  {
            Log.i("HELLO WORL CLICK", "ID: $it")
        }
    }
}
