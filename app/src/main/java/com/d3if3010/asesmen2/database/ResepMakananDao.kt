package com.d3if3010.asesmen2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.d3if3010.asesmen2.model.ResepMakanan
import kotlinx.coroutines.flow.Flow

@Dao
interface ResepMakananDao {

    @Insert
    suspend fun insert(resepMakanan: ResepMakanan)

    @Update
    suspend fun update(resepMakanan: ResepMakanan)

    @Query("SELECT * FROM resepMakanan ORDER BY waktuMembuat DESC")
    fun getResepMakanan(): Flow<List<ResepMakanan>>

    @Query("SELECT * FROM resepMakanan WHERE id = :id")
    suspend fun getResepMakananById(id: Long?): ResepMakanan?

    @Query("DELETE FROM resepMakanan WHERE id = :id")
    suspend fun deleteById(id: Long)
}