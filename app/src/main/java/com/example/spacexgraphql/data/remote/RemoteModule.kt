package com.example.spacexgraphql.data.remote

import com.example.spacexgraphql.data.remote.users.RemoteUsers
import com.example.spacexgraphql.data.remote.users.RemoteUsersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun bindsRemoteUsers(
        remoteUsersImpl: RemoteUsersImpl
    ): RemoteUsers

}