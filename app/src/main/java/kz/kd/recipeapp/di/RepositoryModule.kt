package kz.kd.recipeapp.di

import kz.kd.recipeapp.data.repositories.FoodsRepositoryImpl
import kz.kd.recipeapp.domain.repositories.FoodsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<FoodsRepository> { FoodsRepositoryImpl(get()) }
}