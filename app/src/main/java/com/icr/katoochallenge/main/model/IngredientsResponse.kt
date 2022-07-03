package com.icr.katoochallenge.main.model

import com.google.gson.annotations.SerializedName

data class IngredientsResponse(
    @SerializedName("drinks") val ingredients: List<Ingredient>
)