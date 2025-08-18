package com.htech.ktorkoin.core

sealed class Failure(val message: String? = null) {
    class Network(message: String? = null) : Failure(message)
    class Server(message: String? = null,val code:Int? = null) : Failure(message)
    class Serialization(message: String? = null): Failure(message)
    class Unknown(message: String? = null): Failure(message)
}