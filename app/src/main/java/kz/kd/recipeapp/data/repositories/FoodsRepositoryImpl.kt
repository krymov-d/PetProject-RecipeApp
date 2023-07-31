package kz.kd.recipeapp.data.repositories

import kz.kd.recipeapp.data.mapper.toFoodItem
import kz.kd.recipeapp.data.network.MainApi
import kz.kd.recipeapp.domain.models.FoodItem
import kz.kd.recipeapp.domain.repositories.FoodsRepository

class FoodsRepositoryImpl(private val mainApi: MainApi) : FoodsRepository {
    override suspend fun getFoodItems(searchQuery: String): List<FoodItem> {
        return toFoodItem(mainApi.getFoodItems(ingr = searchQuery))
    }
}