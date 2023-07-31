package kz.kd.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.kd.recipeapp.domain.models.FoodItem
import kz.kd.recipeapp.domain.use_cases.GetFoodItemsUseCase

class MainViewModel (private val getFoodItemsUseCase: GetFoodItemsUseCase) : ViewModel() {
//    private val _searchValue = MutableLiveData<String>()
//    val searchValue: LiveData<String> = _searchValue

    private val _searchValue = mutableStateOf<String>("")
    val searchValue: State<String> = _searchValue

    private val _foodItemsList = MutableLiveData<List<FoodItem>>()
    val foodItemsList: LiveData<List<FoodItem>> = _foodItemsList

    fun textFieldOnValueChange(newValue: String) {
        _searchValue.value = newValue
    }

    fun getFoodItems() {
        viewModelScope.launch {
            val foodItems = getFoodItemsUseCase(searchQuery = _searchValue.value)
            _foodItemsList.postValue(foodItems)
        }
    }
}