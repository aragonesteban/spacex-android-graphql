package com.example.spacexgraphql.ui.users

import com.example.spacexgraphql.domain.models.User

data class UsersUiState(
    val showLoading: Boolean = false,
    val data: List<User> = listOf(),
    val showError: Boolean = false
)