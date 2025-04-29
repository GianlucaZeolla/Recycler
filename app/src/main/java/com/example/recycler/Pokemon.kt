package com.example.recycler

data class Pokemon(

    val id: Int,
    val name: String,
    val vida: Int,
    val ataque: Int,
    val defensa: Int,
    val velocidad: Int,
    val tipo: TipoPokemon,
    val url: String

)
enum class TipoPokemon {
    PLANTA, AGUA, FUEGO, LUCHA, ELECTRICO
}