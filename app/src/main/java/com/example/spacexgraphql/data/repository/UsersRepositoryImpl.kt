package com.example.spacexgraphql.data.repository

import com.example.spacexgraphql.data.remote.users.RemoteUsers
import com.example.spacexgraphql.domain.models.User
import com.example.spacexgraphql.utils.SpaceXResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val remoteUsers: RemoteUsers
) : UserRepository {
    override suspend fun getUsersList(): SpaceXResult<List<User>> {
        return withContext(Dispatchers.IO) {
            remoteUsers.getUsersList()
        }
    }
}