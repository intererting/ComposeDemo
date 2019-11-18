package com.yly.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.core.gesture.PressGestureDetector
import androidx.ui.core.gesture.PressReleasedGestureDetector
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("haha")
        }
    }
}

@Composable
fun Greeting(name: String) {
    //viewModel数据刷新
    val testModel = TestModel("yuliyang")
    //测试State数据刷新
    val stateModel = +state { "stateBefore" }
    Column(
        crossAxisSize = LayoutSize.Expand,
        crossAxisAlignment = CrossAxisAlignment.Center
    ) {
        //测试slot存储
        val testMemo = +memo { testMemo() }
        Text(text = "testMemo $testMemo")
        HeightSpacer(height = 30.dp)
        Text(text = "testModel.name  ${testModel.name}")
        HeightSpacer(height = 30.dp)
        Text(text = "stateModel  ${stateModel.value}")
        HeightSpacer(height = 30.dp)
        PressReleasedGestureDetector(onRelease = { testModel.name = "after change" }) {
            Text(text = "clickTestModel")
        }
        HeightSpacer(height = 30.dp)
        PressReleasedGestureDetector(onRelease = { stateModel.value = "stateAfter" }) {
            Text(text = "clickTestState")
        }
        //测试slots的bug,slot位未刷新，获取的还是缓存值
        val randomNum = Math.random()
        println("randomNum  $randomNum")
        if (randomNum > 0.5) {
            val slotA = +memo { slotA() }
            println("slotA  $slotA")
        } else {
            val slotB = +memo { slotB() }
            println("slotB  $slotB")
        }
    }
}

@Model
data class TestModel(
    var name: String
)

fun testMemo(): String {
    println("init memo")
    return "haha init"
}

@Composable
fun imageTest() {

}

fun slotA(): String {
    println("slotA init")
    return "slotA"
}

fun slotB(): String {
    println("slotB init")
    return "slotB"
}

@Preview
@Composable
fun DefaultPreview() {
    Column(
        modifier = Spacing(Dp(12F)),
        crossAxisSize = LayoutSize.Expand,
        mainAxisSize = LayoutSize.Expand
    ) {
        Container(expanded = true, height = 180.dp) {
            Clip(shape = RoundedCornerShape(15)) {
                DrawImage(image = +imageResource(R.drawable.header))
            }
        }
        Align(alignment = Alignment.TopRight) {
            Text(text = "top Right")
        }
        Text(text = "hahah")
        PressReleasedGestureDetector(onRelease = { }) {
            Text(text = "clickTest")
        }
    }

}

