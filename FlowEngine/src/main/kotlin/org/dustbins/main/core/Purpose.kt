package org.dustbins.main.core

import java.util.*
import kotlin.collections.ArrayDeque

/**
 * <pre>
 *    &#064; dd
 * </pre>
 * @property name name
 * @property content content
 * @property level archive level,it means its difficulties;it is an enum.
 * @property parent its parent purpose
 * @property id its id
 * @property generation the id stack
 * @constructor name,content,parentId,parentDeque
 * @sample samplePurpose
 * @see Engine
 */
class Purpose {

    private constructor()
    constructor(name: String){
        this.name=name
        this.content=name
        this.generation.add(this.id)
    }
    constructor(name: String,content: String){
        this.name=name
        this.content=content
        this.generation.add(this.id)
    }
    constructor(name: String,content: String,id: String,generationDeque: (id:String)->ArrayDeque<String>){
        this.name=name
        this.content=content
        this.parent=id
        this.generation.addAll(generationDeque(id))
        this.generation.add(this.id)
    }
//    fun

//    constructor(id: String,na){}

    constructor(body: (name:String,content:String) -> Array<String>) {
//        this.name=body
//        val body1 = body

    }
    var parent:String?=null
//        private set(value) {
//            if (value != null) {
////                    if (value.parent != null) {
//                    this.generation.addAll(loadPurposeFrom(value).generation)
////                    }
//            }
//            field = value
//        }


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
     * io operation?
     * does it in right way?may be not.
     * <pre>
     *   &#064; dd
     * </pre>
     * @return from dbData or Data
     */
    @Deprecated("no properly function here")
    private fun loadPurposeFrom(id:String): Purpose {
        return Purpose()
    }

    override fun toString(): String {

        return "{Purpose:id=$id,name=$name,parent=$parent,content=$content,level=$level}"
    }
}
fun samplePurpose(){
    //name init
    Purpose("name")
    //name and content init
    Purpose("name","content")
    //with parent init ;this genDq from id
    Purpose("name","content","id") {
//        Purpose("d").generation
        getPurposeById(id = "id").generation
    }

}
    fun getPurposeById(id: String): Purpose {
        return dbOperation(id)
    }
fun dbOperation(id: String): Purpose {
    return Purpose("")
}