package com.example.spacexgraphql.data.remote.users

import com.example.spacexgraphql.domain.models.User
import com.example.spacexgraphql.utils.SpaceXResult

interface RemoteUsers {
    suspend fun getUsersList(): SpaceXResult<List<User>>
}