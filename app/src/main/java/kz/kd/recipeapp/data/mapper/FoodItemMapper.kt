package kz.kd.recipeapp.data.mapper

import kz.kd.recipeapp.data.models.SearchResponse
import kz.kd.recipeapp.domain.models.FoodItem

fun toFoodItem(searchResponse: SearchResponse): List<FoodItem> {
    return searchResponse.hints.map { hint ->
        FoodItem(
            foodId = hint.food.foodId,
            label = hint.food.label,
            calories = 0f,
            image = "https://www.edamam.com/food-img/d33/d338229d774a743f7858f6764e095878.jpg"
        )

//        FoodItem(
//            foodId = hint.food.foodId,
//            label = hint.food.label,
//            calories = hint.food.nutrient.ENERC_KCAL,
//            image = hint.food.image
//        )
    }
}