package kz.kd.recipeapp.data.network

import kz.kd.recipeapp.constants.APP_ID
import kz.kd.recipeapp.constants.APP_KEY
import kz.kd.recipeapp.constants.NUTRITION_TYPE
import kz.kd.recipeapp.data.models.SearchResponse
import retrofit2.http.*

interface MainApi {

    @GET("parser")
    suspend fun getFoodItems(
        @Query("app_id") app_id: String = APP_ID,
        @Query("app_key") app_key: String = APP_KEY,
        @Query("nutrition-type") nutrition_type: String = NUTRITION_TYPE,
        @Query("ingr") ingr: String,
    ): SearchResponse

}