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
//    var testMemo = +memo { testMemo() }
//    var testMemo = "1111111111111111"
    val testModel = TestModel("yuliyang")
    Column(
        crossAxisSize = LayoutSize.Expand,
        crossAxisAlignment = CrossAxisAlignment.Center
    ) {
        var testMemo = +memo { testMemo() }
        Text(text = "Hello $testMemo")
        HeightSpacer(height = 20.dp)
        Text(text = testModel.name)
        HeightSpacer(height = 20.dp)
        PressReleasedGestureDetector(onRelease = { testModel.name = "after change" }) {
            Text(text = "clickTest")
        }
        HeightSpacer(height = 200.dp)
        PressReleasedGestureDetector(onRelease = { testMemo = "after change___________" }) {
            Text(text = "clickTest____B")
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

