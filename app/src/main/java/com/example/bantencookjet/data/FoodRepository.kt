package com.example.bantencookjet.data

import com.example.bantencookjet.model.Food
import com.example.bantencookjet.model.FoodDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FoodRepository {

    private val foods = mutableListOf<Food>()

    init {
        if (foods.isEmpty()) {
            FoodDataSource.dummyFood.forEach {
                foods.add(Food(it.id, it.image, it.name, it.description, it.estimatePrice))
            }
        }
    }

    fun getAllFood(): Flow<List<Food>> {
        return flowOf(foods)
    }

    fun getOrderRewardById(foodId: Long): Food {
        return foods.first {
            it.id == foodId
        }
    }

    companion object {
        @Volatile
        private var instance: FoodRepository? = null

        fun getInstance(): FoodRepository =
            instance ?: synchronized(this) {
                FoodRepository().apply {
                    instance = this
                }
            }
    }
}