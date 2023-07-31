package kz.kd.recipeapp.domain.use_cases

import kz.kd.recipeapp.domain.models.FoodItem
import kz.kd.recipeapp.domain.repositories.FoodsRepository

class GetFoodItemsUseCase(private val foodsRepository: FoodsRepository) {
    suspend operator fun invoke(searchQuery: String): List<FoodItem> {
        return foodsRepository.getFoodItems(searchQuery = searchQuery)
    }
}