package com.yassir.yassirmovies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yassir.yassirmovies.models.Movie
import com.yassir.yassirmovies.models.Show
import com.yassir.yassirmovies.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {


    val showList : MutableLiveData<ArrayList<Show>> = MutableLiveData()
    val movieList : MutableLiveData<ArrayList<Movie>> = MutableLiveData()


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

    fun getMovies(){
        viewModelScope.launch {
            try{
                val result = MainRepository.getMoviesAsync().await()
                if(result != null){
                    movieList.value = result.movies
                }else{
                    movieList.value = arrayListOf()
                }
            }catch (e: Exception){
                movieList.value = arrayListOf()
            }
        }
    }
}