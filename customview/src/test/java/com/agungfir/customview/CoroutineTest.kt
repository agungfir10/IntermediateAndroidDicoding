package com.agungfir.customview

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoroutineTest {

    @Test
    fun testCoroutine() {
        runBlocking {
            println("Lorem ipsum")
        }
        CoroutineScope(Dispatchers.IO).launch {
            println("Hello World")
        }

        println("Halo Dunia")
    }
}