package com.example.plugins

import com.example.model.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            // Obtendo os parâmetros da consulta
            val queryParameters = call.request.queryParameters

            // Construindo uma resposta que inclui os parâmetros
            val responseText = StringBuilder("Request URI: ${call.request.uri}\n")
            if (queryParameters.isEmpty()) {
                responseText.append("No query parameters.")
            } else {

                val person: Any? =
                    if (queryParameters.contains("name") && queryParameters.contains("height") && queryParameters.contains(
                            "weigth"
                        )
                    ) {
                        val name = queryParameters["name"] ?: ""
                        val height = queryParameters["height"]?.toDoubleOrNull() ?: 0.0
                        val weigth = queryParameters["weigth"]?.toDoubleOrNull() ?: 0.0
                        call.respond(
                            Person(name, height, weigth).imc()
                        )
                    } else {
                        responseText.append(queryParameters)
                    }
            }

            call.respondText(responseText.toString(), ContentType.Text.Plain)
        }
    }
}
