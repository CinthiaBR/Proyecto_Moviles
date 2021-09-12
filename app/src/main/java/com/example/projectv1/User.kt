package com.example.projectv1

class User {
    var Nombre: String? = null
    var NombreUsuario: String? = null
    var fecha: String? = null
    var password: String? = null
    var password2: String? = null

    constructor() {}
    constructor(
        Nombre: String?,
        NombreUsuario: String?,
        fecha: String?,
        password: String?,
        password2: String?
    ) {
        this.Nombre = Nombre
        this.NombreUsuario = NombreUsuario
        this.password = password
        this.password2 = password2
        this.fecha = fecha
    }
}