package com.example.submissiongithub.ViewModel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissiongithub.API.ApiConfig
import com.example.submissiongithub.Model.DetailUserModel
import com.loopj.android.http.AsyncHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Headers

class DetailViewModel: ViewModel() {

    val detailUser = MutableLiveData<DetailUserModel>()

    fun setDetailUser(username: String){
        ApiConfig.getApiService()
            .getDetailUsers(username)
            .enqueue(object : Callback<DetailUserModel>{
                override fun onResponse(
                    call: Call<DetailUserModel>,
                    response: Response<DetailUserModel>
                ) {
                    if(response.isSuccessful){
                        detailUser.postValue(response.body())

                    }
                }

                override fun onFailure(call: Call<DetailUserModel>, t: Throwable) {
                    Log.d("onFailure", t.message.toString())

                }

            })

    }



    fun getUserDetail(): LiveData<DetailUserModel> {
        return detailUser
    }





}