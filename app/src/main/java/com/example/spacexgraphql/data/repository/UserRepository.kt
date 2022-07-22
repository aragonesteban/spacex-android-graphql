package com.example.spacexgraphql.data.repository

import com.example.spacexgraphql.domain.models.User
import com.example.spacexgraphql.utils.SpaceXResult

interface UserRepository {
    suspend fun getUsersList(): SpaceXResult<List<User>>
}