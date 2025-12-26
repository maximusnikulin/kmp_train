package com.example.kmp_train

import ZeusApiPackage.Authentication
import io.github.timortel.kmpgrpc.core.Channel
import io.github.timortel.kmpgrpc.core.StatusException
import io.github.timortel.kmpgrpc.core.util.TimeUnit
import kotlin.time.Duration.Companion.seconds

class NewsService
constructor(
//    private val networkClient: NetworkClient, private val storage: Storage
) {
    fun loadData() {
        // TODO: здесь будет реализация запроса к API
        val request = ZeusApiPackage.signInEmailRequest {
            deviceId = "123"
            pointOfContact = "some"
        }

        println(request.toString())
    }

    suspend fun makeCall(): String {
        val channel = Channel.Builder
            .forAddress("localhost", 3000) // replace with your address and your port
            .usePlaintext() // To force grpc to allow plaintext traffic, if you don't call this https is used.
            .build()

        // For each service a unique class is generated.
        val stub = Authentication.AuthenticationServiceStub(channel)
        val req = ZeusApiPackage.confirmPhoneCodeRequest() {
            phone = "11111"
            code = "1234"
        }

        return try {
            val response: Authentication.SignInSuccessResponse = stub
                .withDeadlineAfter(10.seconds) // Specify a deadline if you need to
                .ConfirmPhoneCode(req)

            //Handle response
            response.refreshToken
        } catch (e: StatusException) {
            "An exception occurred: $e"
        }
    }
}