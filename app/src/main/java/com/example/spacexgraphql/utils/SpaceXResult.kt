package com.example.spacexgraphql.utils

sealed interface SpaceXResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : SpaceXResult<T>
    data class Error(val message: String? = String()) : SpaceXResult<Nothing>
}
