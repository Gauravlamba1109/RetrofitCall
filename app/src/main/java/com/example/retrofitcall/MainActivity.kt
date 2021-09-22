package com.example.retrofitcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intData();
    }
    private fun intData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java).getData()

        retrofit.enqueue(object : Callback<Outerdata> {
            override fun onResponse(call: retrofit2.Call<Outerdata>, response: Response<Outerdata>) {
                val responseBody = response.body()
                if(responseBody!=null){
                    Log.d("MainActivity", "onResponse working$responseBody")
                    Log.d("MainActivity", "onResponse working${responseBody.entries.toString()}")
                    recyclerV.adapter = MAdapter(this@MainActivity, responseBody.entries)
                    recyclerV.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: retrofit2.Call<Outerdata>, t: Throwable) {
                Log.d("MainActivity","onFailure"+t.message)
            }
        })
    }
}

