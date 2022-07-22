package com.example.spacexgraphql.data.remote.api

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.example.spacexgraphql.utils.SpaceXResult

internal inline fun <T : Operation.Data> executeApolloRequest(block: () -> ApolloResponse<T>): SpaceXResult<T> {
    return try {
        val response = block.invoke()
        if (response.errors != null && response.errors?.isNotEmpty() == true) {
            val error = response.errors?.first()
            SpaceXResult.Error(error?.message)
        } else {
            response.data?.let {
                SpaceXResult.Success(it)
            } ?: SpaceXResult.Error("Body is empty")
        }
    } catch (e: Exception) {
        SpaceXResult.Error(e.message)
    }
}

fun <Api : Any, Data: Any> handleApolloResponse(
    result: SpaceXResult<Api>,
    onSuccess: (Api) -> Data
): SpaceXResult<Data> {
    return when (result) {
        is SpaceXResult.Success -> SpaceXResult.Success(onSuccess.invoke(result.data))
        is SpaceXResult.Error -> result
    }
}

