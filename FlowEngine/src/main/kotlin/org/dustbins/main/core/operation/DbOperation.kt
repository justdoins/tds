package org.dustbins.main.core.operation

interface DbOperation{
    fun read()

    fun delete()

    fun update()

    fun create()

    fun init()
}