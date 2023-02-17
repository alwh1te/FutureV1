package com.example.futurev1
//Первый раз делаю такого рода приложение)
//Ничего не вышло(
//Не успел
import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.futurev1.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import kotlinx.serialization.json.Json
import org.json.JSONArray
import retrofit2.Call
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    lateinit var bin : ActivityMainBinding
    var arr = arrayListOf<String>()
    val url = "http://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)


        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getPosts()

        call.enqueue(object : retrofit2.Callback<MutableList<Item>> {
            override fun onResponse(
                call: retrofit2.Call<MutableList<Item>>,
                response: retrofit2.Response<MutableList<Item>>) {
                    if(response.isSuccessful){
                        Log.e("success" , "success")

                        var adapter = ItemAdapter(response.body()!!)
                        bin.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
                        bin.rcView.adapter = adapter

                }

            }

            override fun onFailure(call: Call<MutableList<Item>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", "error")

            }


        })

    }

//    private fun init(){
//        bin.apply {
//            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
//            rcView.adapter = adapter
//        }
//    }


//    fun readJson(){
//
//        //val projects = Json.decodeFromString<Item>(assets.open("projects.json"))
//
//        var item = Item(null, null, null, null)
//
//        var json : String? = null
//        try {
//            val inputStream: InputStream = assets.open("projects.json")
//            json = inputStream.bufferedReader().use { it.readText() }
//
//            var jsonarr = JSONArray(json)
//
//            for(i in 0..jsonarr.length()){
//                var jsonobj = jsonarr.getJSONObject(i)
//                Log.d("MY", "${i}")
//                item.name = jsonobj.getString("name")
//                item.description = jsonobj.getString("description")
//                item.iconUrl = jsonobj.getString("icon_url")
//                item.serviceUrl = jsonobj.getString("service_url")
//            }
//
//
//            var adpt = ArrayAdapter(this, R.layout.simple_list_item_1, arr)
//
//
//
//        }
//        catch (e : IOException){
//
//        }
//    }
}