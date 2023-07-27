package kz.kd.recipeapp

import android.app.Application
import kz.kd.recipeapp.di.networkModule
import kz.kd.recipeapp.di.repositoryModule
import kz.kd.recipeapp.di.useCaseModule
import kz.kd.recipeapp.di.viewModelModule
import org.koin.core.context.startKoin

class RecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}