package com.example.spacexgraphql.data.remote.users

import com.example.app.GetUsersQuery
import com.example.spacexgraphql.data.remote.api.SpaceXApi
import com.example.spacexgraphql.data.remote.api.executeApolloRequest
import com.example.spacexgraphql.data.remote.api.handleApolloResponse
import com.example.spacexgraphql.domain.models.User
import com.example.spacexgraphql.utils.SpaceXResult
import javax.inject.Inject

class RemoteUsersImpl @Inject constructor(
    private val spaceXApi: SpaceXApi
) : RemoteUsers {

    override suspend fun getUsersList(): SpaceXResult<List<User>> {
        val result = executeApolloRequest { spaceXApi.invoke().query(GetUsersQuery()).execute() }
        return handleApolloResponse(result) {
            it.users.transformToUsersList()
        }
    }

}