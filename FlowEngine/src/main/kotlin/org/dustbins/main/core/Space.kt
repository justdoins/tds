package org.dustbins.main.core

import org.dustbins.main.core.model.Purpose
import org.dustbins.main.core.operation.SpaceOperation

/**
 * not gonna to create a new webClintAndService,but to implement from ktor
 */
class Space: SpaceOperation {

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