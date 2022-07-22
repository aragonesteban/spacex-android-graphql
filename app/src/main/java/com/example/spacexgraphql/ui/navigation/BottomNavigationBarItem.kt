package com.example.spacexgraphql.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.spacexgraphql.R

const val SHIPS_ROUTE = "ships"
const val USERS_ROUTE = "users"

sealed class BottomNavigationBarItem(
    val route: String,
    val title: Int,
    val icon: ImageVector,
) {
    object Ships : BottomNavigationBarItem(
        route = SHIPS_ROUTE,
        title = R.string.label_ships,
        icon = Icons.Default.Home
    )

    object Users : BottomNavigationBarItem(
        route = USERS_ROUTE,
        title = R.string.label_users,
        icon = Icons.Default.Person
    )
}
