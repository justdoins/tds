package org.dustbins.main

//import ch.qos.logback.classic.Logger
//import io.github.oshai.kotlinlogging.KotlinLogging
//import io.ktor.client.plugins.logging.*
//import io.ktor.client.plugins.logging.Logger
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.logging.*
//import io.ktor.util.logging.*
import org.dustbins.main.core.Engine
import org.dustbins.main.core.Purpose
import org.dustbins.main.core.Space
import org.dustbins.main.ktor.module
import kotlin.concurrent.thread

//private val logger = KotlinLogging.logger {}
//public val logger =Logger
private const val name = "FlowEngine"

/**
 * start code from here,from head to toe.
 * normally we don't do this in class.
 */
class Main :Init{


    /**
     *
     *
     * @param
     *
     * @return
     */
    private fun loadSpace() {

        loadEngine()

    }

    private fun loadEngine() {
//        ThreadLocal<Engine>()
        val main = Space.MAIN
//        logger.info { main.NAME+"$main+${Space.MAIN}" }
//        logger.debug { "$main" }
        val createEngineByPurpose = createEngineByPurpose()
        val purpose = Purpose("dd")
//        logger.debug { purpose }
//        logger.debug { createEngineByPurpose }
//        val name="d"
//        val content=""
//        Purpose{name, content ->  }

    }

    private fun loadPurposeList():MutableList<Purpose>{

        return extracted()
    }

    fun createEngineByPurpose(purpose: Purpose): Engine {


        return Engine{loadPurposeList()}
//        (Engine.Purpose("demo"))
    }
    private fun createEngineByPurpose(): Engine {
//        extracted()
        return Engine{loadPurposeList()}
//        (Engine.Purpose("demo"))
    }

    private fun extracted():MutableList<Purpose> {
        val purpose1 = Purpose("1")
        val purpose2 = Purpose("2")
        val purpose3 = Purpose("3")
        val purpose4 = Purpose("4")
        val purpose5 = Purpose("5")
        val purpose6 = Purpose("6")
        val purpose7 = Purpose("7")

        return mutableListOf(purpose1,purpose2,purpose3,purpose4,purpose5,purpose6,purpose7)
    }

    override fun init(){
        loadSpace()
        
    }


}
interface Init{
    fun init()
}


fun doNothing() {
    thread { }
}

/**
 * if there is a main entrance
 */
fun main() {
    //logger
//    logger.info { "welcome using $name" }
//    logger.debug { "this is a debug message" }
//    logger
//    val logger=Logger
    doNothing()
    Main().init()
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)

}
