package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val name: String,
    val height: Double,
    val weigth: Double,
){
    fun imc(): String {
        val imc =  weigth / (height * 2)
        if (imc < 18.5){
            return "Magresa"
        }else if (imc > 18.5 && imc < 24.9){
            return "Normal"
        }else if(imc > 24.9 && imc < 29.9){
            return "Sobrepeso"
        }else if(imc > 29.9 && imc < 39.9){
            return "Obesidade"
        }else{
            return "Obesidade Grave"
        }
    }
}