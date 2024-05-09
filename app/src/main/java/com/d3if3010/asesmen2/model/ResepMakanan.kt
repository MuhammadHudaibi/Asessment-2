package com.d3if3010.asesmen2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resepMakanan")
data class ResepMakanan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val description: String,
    val caraPembuatan: String,
    val waktuMembuat: String,
)