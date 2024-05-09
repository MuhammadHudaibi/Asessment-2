package com.d3if3010.asesmen2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d3if3010.asesmen2.database.ResepMakananDao
import com.d3if3010.asesmen2.ui.screen.DetailViewModel
import com.d3if3010.asesmen2.ui.screen.MainViewModel

class ViewModelFactory(private val dao: ResepMakananDao): ViewModelProvider.Factory {
    @Suppress("uncheck_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        }
        else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}