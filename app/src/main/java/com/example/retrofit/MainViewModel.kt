package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPost2: MutableLiveData<Response<List<Post>>> = MutableLiveData()


    // POST request
    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }


    fun pushPost2(userId: Int, id: Int, title: String, body: String){
        viewModelScope.launch {
            val response = repository.pushPost2(userId,id,title,body)
            myResponse.value = response
        }
    }

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            // the response will be stored in mutable live data
            myResponse.value = response
        }
    }


    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }


    fun getCustomPosts(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPost.value = response
        }
    }


    fun getCustomPosts2(userId: Int, option: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, option)
            myCustomPost2.value = response
        }
    }















}