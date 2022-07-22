package com.example.spacexgraphql.data.remote.users

import com.example.app.GetUsersQuery
import com.example.spacexgraphql.domain.models.User

fun List<GetUsersQuery.User>.transformToUsersList(): List<User> {
    return map { user ->
        User(
            id = user.id.toString(),
            name = if (user.name != null && user.name.isNotBlank()) user.name else "No name"
        )
    }
}