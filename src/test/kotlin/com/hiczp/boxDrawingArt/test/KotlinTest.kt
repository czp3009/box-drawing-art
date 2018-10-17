package com.hiczp.boxDrawingArt.test

import com.hiczp.boxDrawingArt.toBoxDrawingArt
import org.junit.After
import org.junit.Test

class KotlinTest {
    @Test
    fun normal() = println("Box Drawing Art".toBoxDrawingArt())

    @Test
    fun emptyString() = println("".toBoxDrawingArt())

    @After
    fun printNonEmptyLine() = println("!")
}
