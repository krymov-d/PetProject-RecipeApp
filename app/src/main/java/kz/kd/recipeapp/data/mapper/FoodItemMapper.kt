package kz.kd.recipeapp.data.mapper

import kz.kd.recipeapp.data.models.SearchResponse
import kz.kd.recipeapp.domain.models.FoodItem

fun toFoodItem(searchResponse: SearchResponse): List<FoodItem> {
    return searchResponse.hints.map { hint ->
        FoodItem(
            foodId = hint.food.foodId,
            label = hint.food.label,
            calories = hint.food.nutrients.ENERC_KCAL,
            image = hint.food.image ?: ""
        )
    }
}