package com.example.shemajamebeli6.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli6.model.Content
import com.example.shemajamebeli6.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class AnnouncementViewModel : ViewModel() {

    private val _data = MutableLiveData<Response<Content>>()
    val data: MutableLiveData<Response<Content>> get() = _data

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
           val response =  try {
               NetworkClient.userService.getAnnouncements()
            } catch (e: IOException) {
                e.message
                return@launch
            }catch (e : HttpException){
               e.message
               return@launch
            }
            if (response.isSuccessful && response.body() != null){
                _data.postValue(response)
            }
        }
    }

}