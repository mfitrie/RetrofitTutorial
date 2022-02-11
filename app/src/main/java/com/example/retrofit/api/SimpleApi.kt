package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    // if want to specify the custom header
    @Headers(
        "Authorization: 123123123",
        "Platform: Android"
    )
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(@Path("postNumber") number: Int): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>


    // QueryMap will reduce the number of query parameter
    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap option: Map<String, String>
    ): Response<List<Post>>


    @POST("posts")
    suspend fun pushPost(@Body post: Post): Response<Post>


    // FormUrlEncoded is where to specified the data to be send, the default retrofit is json, if specified, it will encode the data to urlEncoded
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String,
    ): Response<Post>




}