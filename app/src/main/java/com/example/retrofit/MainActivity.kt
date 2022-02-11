package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost()




        button.setOnClickListener{
            val myNumber = etNumber.text.toString()

            // hardcode the sort and order for example purpose
            viewModel.getCustomPosts(Integer.parseInt(myNumber), "id", "desc")

            // observe the data
            viewModel.myCustomPost.observe(this, Observer { response ->

                // only if request is successful
                if(response.isSuccessful){

                    tvText.text = response.body().toString()
                    response.body()?.forEach{
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "--------------------------------")
                    }
                }else{
                    Log.d("Response", response.errorBody().toString())
                    tvText.text = response.code().toString()

                }
            })

        }


    }
}