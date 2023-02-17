package com.example.futurev1

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futurev1.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    lateinit var bin : ActivityMainBinding
    private var adapter = ItemAdapter()
    var arr = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)
        init()
    }

    private fun init(){
        bin.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
        }
    }

    fun readJson(){

        var myData = Item()

        var json : String? = null
        try {
            val inputStream: InputStream = assets.open("projects.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonarr = JSONArray(json)

            for(i in 0..jsonarr.length()){
                var jsonobj = jsonarr.getJSONObject(i)
                myData.name = jsonobj.getString("name")
                myData.description = jsonobj.getString("description")
                myData.iconUrl = jsonobj.getString("icon_url")
                myData.serviceUrl = jsonobj.getString("service_url")
            }


            var adpt = ArrayAdapter(this, R.layout.simple_list_item_1, arr)



        }
        catch (e : IOException){

        }
    }
}