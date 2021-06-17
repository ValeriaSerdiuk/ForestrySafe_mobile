package com.example.forestrysafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forestrysafe.model.Feeder
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_authorized.*
import okhttp3.*
import java.io.IOException


class AuthorizedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorized)

        val recyclerView_feeder = findViewById<RecyclerView>(R.id.recyclerView_feeder)
        recyclerView_feeder.layoutManager = LinearLayoutManager(this)
        //recyclerView_feeders.adapter = AuthorizedAdaptor()

        fetchJson()
    }

    fun fetchJson(){
        val url = "http://192.168.1.49:8000/api/feeders/all"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println("OKOK")
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, Array<Feeder>::class.java).toList()
                val rv = findViewById<RecyclerView>(R.id.recyclerView_feeder)
                runOnUiThread{
                    rv.adapter = AuthorizedAdaptor(homeFeed)
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
                println(e)
            }
        })
    }




}