package kz.kd.recipeapp.domain.repositories

import kz.kd.recipeapp.domain.models.FoodItem

interface FoodsRepository {
    suspend fun getFoodItems(searchQuery: String): List<FoodItem>
}