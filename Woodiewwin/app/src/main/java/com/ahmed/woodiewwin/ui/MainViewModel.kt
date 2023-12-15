package com.ahmed.woodiewwin.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {
    val screenState = mutableStateOf<UiState>(UiState.Explore)

    sealed class UiState {
        object Explore : UiState()
    }
}