package com.example.futurev1
//Первый раз делаю такого рода приложение)
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futurev1.databinding.ActivityMainBinding
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    lateinit var bin : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)


        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getPosts()

        call.enqueue(object : retrofit2.Callback<MutableList<Item>> {
            override fun onResponse(
                call: Call<MutableList<Item>>,
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

}