package com.icr.katoochallenge.cocktails.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("strDrink") val name: String,
    @SerializedName("strDrinkThumb") val image: String,
    @SerializedName("idDrink") val id: String
)