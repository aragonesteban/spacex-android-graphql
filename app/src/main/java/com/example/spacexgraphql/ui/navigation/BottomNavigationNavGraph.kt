package com.example.spacexgraphql.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spacexgraphql.ui.ships.ShipsScreen
import com.example.spacexgraphql.ui.users.UsersScreen

@Composable
fun BottomNavigationNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationBarItem.Ships.route) {
        composable(BottomNavigationBarItem.Ships.route) {
            ShipsScreen()
        }
        composable(BottomNavigationBarItem.Users.route) {
            UsersScreen()
        }
    }
}