package com.fcfm.poi.chat.modelos

import com.google.firebase.database.Exclude

class Usuario (
    var id: String = "",
    var nombre: String = ""
) {
    @Exclude
    var Activo: Boolean = true
}