package com.yly.composedemo

import androidx.annotation.CheckResult
import org.junit.Test

import org.junit.Assert.*

interface Controller {
    fun OptionUtil.start()
}

class ControllerImplA : Controller {
    override fun OptionUtil.start() {
        println("I AM A")
    }
}

class ControllerImplB : Controller {
    override fun OptionUtil.start() {
        println("I AM B")
    }
}

class OptionUtil {

}

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val impl = ControllerImplA()
        val optionUtil = OptionUtil()
        with(impl) {
            optionUtil.start()
        }
    }
}


