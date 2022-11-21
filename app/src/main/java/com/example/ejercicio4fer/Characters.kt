package com.example.ejercicio4fer

data class Characters(val name: String, val description: String, val image: Int) {
    var charName: String? = null
    var charDescription: String? = null
    var charImage: Int? = null

    init {
        this.charName = name
        this.charDescription = description
        this.charImage = image
    }
}
