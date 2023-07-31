package kz.kd.recipeapp.di

import kz.kd.recipeapp.domain.use_cases.GetFoodItemsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetFoodItemsUseCase(get()) }
}