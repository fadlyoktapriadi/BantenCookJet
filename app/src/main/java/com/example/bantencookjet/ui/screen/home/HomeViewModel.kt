package com.example.bantencookjet.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantencookjet.common.UiState
import com.example.bantencookjet.data.FoodRepository
import com.example.bantencookjet.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: FoodRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Food>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Food>>>
        get() = _uiState

    fun getAllFood() {
        viewModelScope.launch {
            repository.getAllFood()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { foods ->
                    _uiState.value = UiState.Success(foods)
                }
        }
    }
}