package org.dustbins.main.core

import org.dustbins.main.core.model.Purpose

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