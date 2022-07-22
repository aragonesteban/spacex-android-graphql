package com.example.spacexgraphql.ui.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.spacexgraphql.domain.models.User
import com.example.spacexgraphql.ui.theme.DeepOrange400

@Composable
fun UsersScreen(viewModel: UsersViewModel = hiltViewModel()) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }
    ) {
        val (showLoading, data, showError) = viewModel.uiState.value

        if (showLoading) {
            LoadingUsersList()
        }

        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            items(data) { user ->
                UserRow(user)
            }
        }
    }
}

@Composable
fun LoadingUsersList() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(color = DeepOrange400)
    }
}

@Composable
fun UserRow(user: User) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            style = MaterialTheme.typography.h6,
            text = user.name,
        )
        Text(
            style = MaterialTheme.typography.body1,
            text = user.id,
        )
    }
}