package com.zstas.objectone.model

class DummyModel(val x: Int, val y: Int) {

    fun sum(): Int {
        return x + y
    }

    fun min(): Int {
        return x - y
    }
}