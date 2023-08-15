package kz.kd.recipeapp.data.models

data class Food(
    val foodId: String,
    val label: String,
    val knownAs: String,
    val nutrients: Nutrient,
    val category: String,
    val categoryLabel: String,
    val image: String?,
)
