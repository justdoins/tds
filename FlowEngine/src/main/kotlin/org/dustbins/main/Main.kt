package org.dustbins.main

import io.github.oshai.kotlinlogging.KotlinLogging

//import mu.KotlinLogging
private val logger = KotlinLogging.logger {}
private const val name = "FlowEngine"

/**
 * start code from here
 */
class Main {


    fun loadSpace() {
        
    }


}

/**
 * if there is a main entrance
 */
fun main() {
    //logger
    logger.info { "welcome to $name" }
}