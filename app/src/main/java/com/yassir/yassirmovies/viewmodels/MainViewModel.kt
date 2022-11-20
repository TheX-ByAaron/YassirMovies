package com.yassir.yassirmovies.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassir.yassirmovies.models.Show
import com.yassir.yassirmovies.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {


    val showList : MutableLiveData<ArrayList<Show>> = MutableLiveData()


    fun getShows(){
        viewModelScope.launch {
            try{
                val result = MainRepository.getShowsAsync().await()
                if(result != null){
                    showList.value = result.shows
                }else{
                    showList.value = arrayListOf()
                }
            }catch (e: Exception){
                showList.value = arrayListOf()
            }
        }
    }
}