package com.example.homework118

import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun emptyOrNot(){
        val obj = Stack<Int>()
        Assert.assertTrue(obj.isEmpty())
        obj.push(777)
        Assert.assertTrue(!obj.isEmpty())
    }
    @Test
    fun addRemove(){
        val obj = Stack<Int>()
        obj.push(1)
        obj.push(2)
        obj.push(3)
        obj.push(4)
        Assert.assertTrue(obj.listSize() == 4)
        obj.pop()
        Assert.assertTrue(obj.listSize() == 3)
    }
}