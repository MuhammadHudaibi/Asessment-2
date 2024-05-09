package com.d3if3010.asesmen2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3010.asesmen2.database.ResepMakananDao
import com.d3if3010.asesmen2.model.ResepMakanan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: ResepMakananDao): ViewModel() {

    fun insert (judul: String, desk: String, caraMembuat: String, waktu: String){
        val resepMakanan = ResepMakanan(
            title = judul,
            description = desk,
            caraPembuatan = caraMembuat,
            waktuMembuat = waktu
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(resepMakanan)
        }
    }

    suspend fun getResepMakananById(id: Long?): ResepMakanan?{
        return dao.getResepMakananById(id)
    }

    fun update(id: Long, judul: String, desk: String, caraMembuat: String, waktu: String){
        val resepMakanan = ResepMakanan(
            id = id,
            title = judul,
            description = desk,
            caraPembuatan = caraMembuat,
            waktuMembuat = waktu
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(resepMakanan)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}