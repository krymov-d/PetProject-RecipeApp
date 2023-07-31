package kz.kd.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.kd.recipeapp.domain.models.FoodItem
import kz.kd.recipeapp.domain.use_cases.GetFoodItemsUseCase

class MainViewModel (private val getFoodItemsUseCase: GetFoodItemsUseCase) : ViewModel() {

    private val _searchValue = mutableStateOf("")
    val searchValue: State<String> = _searchValue

    private val _foodItemsList = mutableStateOf<List<FoodItem>>(emptyList())
    val foodItemsList: State<List<FoodItem>> = _foodItemsList

    fun textFieldOnValueChange(newValue: String) {
        _searchValue.value = newValue
    }

    fun getFoodItems() {
        viewModelScope.launch {
            val foodItems = getFoodItemsUseCase(searchQuery = _searchValue.value)
            _foodItemsList.value = foodItems
        }
    }
}