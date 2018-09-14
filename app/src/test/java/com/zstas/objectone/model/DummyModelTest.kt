package com.zstas.objectone.model

import org.junit.Assert.assertEquals
import org.junit.Test

class DummyModelTest {

    private val dummyModel = DummyModel(2, 5)

    @Test fun sum() {
        assertEquals(7, dummyModel.sum())
    }

    @Test fun min() {
        assertEquals(-3, dummyModel.min())
    }
}