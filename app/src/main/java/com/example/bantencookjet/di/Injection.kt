package com.example.bantencookjet.di

import com.example.bantencookjet.data.FoodRepository

object Injection {
    fun provideRepository(): FoodRepository {
        return FoodRepository.getInstance()
    }
}