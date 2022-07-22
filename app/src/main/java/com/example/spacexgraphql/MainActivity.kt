package com.example.spacexgraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.spacexgraphql.ui.navigation.BottomNavigationBar
import com.example.spacexgraphql.ui.navigation.BottomNavigationNavGraph
import com.example.spacexgraphql.ui.theme.SpaceXGraphQLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SpaceXGraphQLTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = { ToolbarSpaceX() },
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        BottomNavigationNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun ToolbarSpaceX() {
    TopAppBar(
        title = { Text(text = "SpaceX") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        }
    )
}