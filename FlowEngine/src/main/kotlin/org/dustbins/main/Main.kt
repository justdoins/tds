package org.dustbins.main

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.li
import kotlinx.html.ul
import kotlin.concurrent.thread

private val logger = KotlinLogging.logger {}
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
        logger.info { main.NAME+"$main+${Space.MAIN}" }
        logger.debug { "$main" }
        val createEngineByPurpose = createEngineByPurpose()
        val purpose = Purpose("dd")
        logger.debug { purpose }
        logger.debug { createEngineByPurpose }
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
/**
 * actually do
 */
interface SpaceOperation{
    fun createFinalPurpose()

    fun addSubPurpose()

    fun initialEngine()

    fun showAllPurpose()

    fun detailPurpose()

    fun addNote()

    fun dbType()
}

/**
 * not gonna to create a new webClintAndService,but to implement from ktor
 */
class Space:SpaceOperation{

    private constructor()
    object MAIN{
        const val NAME="Only Space"
    }

    override fun createFinalPurpose() {

//        Engine{ mutableListOf() }

        Purpose("")
        TODO("Not yet implemented")
    }

    override fun addSubPurpose() {
        TODO("Not yet implemented")
    }

    override fun initialEngine() {
        TODO("Not yet implemented")
    }

    override fun showAllPurpose() {
        TODO("Not yet implemented")
    }

    override fun detailPurpose() {
        TODO("Not yet implemented")
    }

    override fun addNote() {
        TODO("Not yet implemented")
    }

    override fun dbType() {
        TODO("Not yet implemented")
    }
}

/**
 * @constructor purpose
 * @property purposeList final purposeList
 * @property
 */
class Engine {
    private constructor()

    constructor(body: Engine.() -> MutableList<Purpose>){
//        logger.debug(body)
        val engine=Engine()
        this.purposeList = engine.body()
        
//        val mutableListOf = mutableListOf<Purpose>()
//        mutableListOf.add(body)
//        body.run {  }
    }
    private constructor(body: Purpose) {
//        this.purpose = body

    }

//    private lateinit var purpose: Purpose

    private  var purposeList: MutableList<Purpose> = mutableListOf()

    fun peelPurposeInEngine(parent: Purpose) {}

    override fun toString(): String {
        return "{$purposeList}"
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
    Main().init()
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)

}
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
            logger.debug { "access /" }
        }
    }
}
fun Application.configureTemplating() {
    routing {
        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }
    }
}
fun Application.configureSecurity() {
    // Please read the jwt property from the config file if you are using EngineMain
    val jwtAudience = "jwt-audience"
    val jwtDomain = "https://jwt-provider-domain/"
    val jwtRealm = "ktor sample app"
    val jwtSecret = "secret"
    authentication {
        jwt {
            realm = jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(jwtSecret))
                    .withAudience(jwtAudience)
                    .withIssuer(jwtDomain)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader("MyCustomHeader")
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }
    routing {
        openAPI(path = "openapi")
    }
}
fun Application.module(){
    configureRouting()
    configureTemplating()
    configureHTTP()
}