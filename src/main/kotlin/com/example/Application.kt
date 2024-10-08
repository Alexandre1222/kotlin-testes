package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import com.example.model.*
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
