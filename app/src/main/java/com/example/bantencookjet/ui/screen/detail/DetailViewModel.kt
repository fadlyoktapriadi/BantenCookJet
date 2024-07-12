package com.example.bantencookjet.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantencookjet.common.UiState
import com.example.bantencookjet.data.FoodRepository
import com.example.bantencookjet.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: FoodRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Food>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Food>>
        get() = _uiState

    fun getFoodById(foodId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderRewardById(foodId))
        }
    }
}