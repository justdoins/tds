package org.dustbins.main

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.concurrent.thread

//import mu.KotlinLogging
private val logger = KotlinLogging.logger {}
private const val name = "FlowEngine"

/**
 * start code from here,from head to toe.
 * normally we don't do this in class.
 */
class Main {


    /**
     *
     *
     * @param
     *
     * @return
     */
    fun loadSpace() {

    }

}
fun doNothing(){
    thread {  }
}
/**
 * if there is a main entrance
 */
fun main() {
    //logger
    logger.info { "welcome using $name" }

}