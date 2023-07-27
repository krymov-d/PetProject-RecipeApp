package kz.kd.recipeapp.di

import kz.kd.recipeapp.constants.BASE_URL
import kz.kd.recipeapp.data.network.MainApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    factory {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        interceptor
    }

    factory {
        val httpLoggingInterceptor: HttpLoggingInterceptor = get()
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        okHttpClient
    }

    factory {
        GsonConverterFactory.create()
    }

    factory<MainApi> {
        val okHttpClient: OkHttpClient = get()
        val gsonConverterFactory: GsonConverterFactory = get()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(MainApi::class.java)
    }
}