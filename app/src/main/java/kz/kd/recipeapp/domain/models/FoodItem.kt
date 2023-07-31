package kz.kd.recipeapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodItem(
    val foodId: String,
    val label: String,
    val calories: Float,
    val image: String,
) : Parcelable