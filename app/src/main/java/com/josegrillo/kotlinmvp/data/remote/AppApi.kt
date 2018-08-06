package com.josegrillo.kotlinmvp.data.remote

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.josegrillo.kotlinmvp.domain.model.api.request.UserRequest
import com.josegrillo.kotlinmvp.domain.model.api.response.Article
import com.josegrillo.kotlinmvp.domain.model.api.response.UserResponse
import com.josegrillo.kotlinmvp.utils.AppConstants
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AppApi {

    @POST("userLogin")
    fun loginUser(@Body userRequest: UserRequest): Observable<UserResponse>

    @POST("userRegister")
    fun registerUser(@Body userRequest: UserRequest): Observable<UserResponse>

    @GET("articles")
    fun getArticles(): Observable<List<Article>>

    companion object Factory {
        fun create(): AppApi {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(LoggingInterceptor.Builder()
                    .loggable(true)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request(AppConstants.REQUEST_TAG)
                    .response(AppConstants.RESPONSE_TAG)
                    .addHeader(AppConstants.HEADER_ACCEPT_TAG, AppConstants.HEADER_APPLICATION_JSON_TAG)
                    .addHeader(AppConstants.HEADER_CONTENT_TYPE_TAG, AppConstants.HEADER_APPLICATION_JSON_TAG)
                    .build())

            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .baseUrl(AppConstants.BASE_URL)
                    .build()

            return retrofit.create(AppApi::class.java)
        }
    }

}