package com.example.spacexgraphql.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexgraphql.data.repository.UserRepository
import com.example.spacexgraphql.utils.SpaceXResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = mutableStateOf(UsersUiState(showLoading = true))
    val uiState: State<UsersUiState> = _uiState

    init {
        getUsersList()
    }

    private fun getUsersList() {
        viewModelScope.launch {
            _uiState.value = when (val result = userRepository.getUsersList()) {
                is SpaceXResult.Success -> UsersUiState(data = result.data)
                is SpaceXResult.Error -> UsersUiState(showError = true)
            }
        }
    }

}