package com.example.midiariodeviajes.data.model

data class Destino(
    val id: Int,
    val name: String,
    val country: String,
    val description: String = "",
    val photoResourceName: String = ""
)

val listaDestinos = listOf(
    Destino(1, "Torre Eiffel", "Francia", "Símbolo icónico de París y la ingeniería francesa."),
    Destino(2, "Machu Picchu", "Perú", "Antigua ciudad inca en las altas montañas andinas."),
    Destino(3, "Gran Cañón", "EE. UU.", "Una imponente garganta tallada por el río Colorado."),
    Destino(4, "Sydney Opera House", "Australia", "Famoso centro de artes escénicas con un diseño único."),
)