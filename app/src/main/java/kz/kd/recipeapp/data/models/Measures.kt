package kz.kd.recipeapp.data.models

data class Measures(
    val uri    : String,
    val label  : String,
    val weight : Float,
    val qualified: List<Qualified> = emptyList(),
)
