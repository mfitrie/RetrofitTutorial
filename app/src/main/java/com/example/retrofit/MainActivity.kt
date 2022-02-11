package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.myAdapter
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {
        myAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycleView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val myPost = Post(2,2,"Sasuke","Android Retrofit")
//        viewModel.pushPost(myPost)
        viewModel.pushPost2(2,2,"Sasuke","Android Retrofit")
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
//                response.body()?.let { myAdapter.setData(it) }
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })



        val options: HashMap<String, String> = HashMap()
        options.put("_sort","id")
        options.put("_order","desc")




    }


    private fun setupRecycleView(){
        rvHolder.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }












}