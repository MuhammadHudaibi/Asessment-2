package com.d3if3010.asesmen2.navigation

import com.d3if3010.asesmen2.ui.screen.KEY_ID_RESEPMAKANAN

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_RESEPMAKANAN}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}