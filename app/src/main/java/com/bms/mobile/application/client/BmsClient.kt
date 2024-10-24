package com.bms.mobile.application.client

import com.message.v1.RegisterRequest
import com.message.v1.RegisterResponse
import com.message.v1.UserServiceGrpcKt
import io.grpc.ManagedChannelBuilder

class BmsClient {
    private val stub:UserServiceGrpcKt.UserServiceCoroutineStub

    init {
        val managedChannel = ManagedChannelBuilder.forAddress("10.0.2.2", 16607)
            .usePlaintext().build()
        stub = UserServiceGrpcKt.UserServiceCoroutineStub(managedChannel)
    }

    suspend fun register(username: String, emailAddress: String): RegisterResponse {
        return stub.register(RegisterRequest.newBuilder()
            .setName(username)
            .setEmailId(emailAddress).build())
    }
}
