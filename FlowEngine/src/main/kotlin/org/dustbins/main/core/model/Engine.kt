package org.dustbins.main.core.model

/**
 * @constructor purpose
 * @property purposeList final purposeList
 * @property
 */
class Engine {
    private constructor()

    constructor(body: Engine.() -> MutableList<Purpose>){
//        logger.debug(body)
        val engine= Engine()
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