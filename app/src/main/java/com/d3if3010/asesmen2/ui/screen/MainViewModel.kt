package com.d3if3010.asesmen2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3010.asesmen2.database.ResepMakananDao
import com.d3if3010.asesmen2.model.ResepMakanan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel (dao: ResepMakananDao): ViewModel(){
    val data: StateFlow<List<ResepMakanan>> = dao.getResepMakanan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}