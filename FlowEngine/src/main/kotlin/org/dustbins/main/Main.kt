package org.dustbins.main

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.UUID
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
        loadEngine()

    }

    fun loadEngine() {}

    fun loadPurposeList():MutableList<Engine.Purpose>{
        return mutableListOf()
    }

    fun createEngineByPurpose(purpose: Engine.Purpose): Engine {
        return Engine{loadPurposeList()}
//        (Engine.Purpose("demo"))
    }


}


/**
 * @constructor purpose
 * @property purpose final purpose
 * @property
 */
class Engine {
    private constructor()

    constructor(body: () -> MutableList<Purpose>){
    }
    private constructor(body: Purpose) {
//        this.purpose = body

    }

//    private lateinit var purpose: Purpose

    private lateinit var purposeList: MutableList<Purpose>

    fun peelPurposeInEngine(parent: Purpose) {}

    /**
     * @property name name
     * @property content content
     * @property level archive level,it means its difficulties;it is an enum.
     * @property parent its parent purpose
     * @property id its id
     * @property generation the id stack
     * @constructor name
     */
    class Purpose {

        private constructor()
        constructor(name: String){
            this.name=name
            this.generation.add(this.id)
        }

        constructor(body: () -> Any?) {

        }
        var parent:String?=null
            private set(value) {
                if (value != null) {
//                    if (value.parent != null) {
                        this.generation.addAll(loadPurposeFrom(value).generation)
//                    }
                }
                field = value
            }


        val generation=ArrayDeque<String>()


        val id = UUID.randomUUID().toString()
        lateinit var name: String
            private set

        lateinit var content: String
            private set

        var level: Level = Level.INF
            private set


        enum class Level {
            INF, CEN, DEC, MON, DAY, MIN, SEC
        }

        /**
         * io operation
         * @return from dbData or Data
         */
        fun loadPurposeFrom(id:String):Purpose{
            return Purpose()
        }


    }

}


fun doNothing() {
    thread { }
}

/**
 * if there is a main entrance
 */
fun main() {
    //logger
    logger.info { "welcome using $name" }
    logger.debug { "this is a debug message" }
    doNothing()

}