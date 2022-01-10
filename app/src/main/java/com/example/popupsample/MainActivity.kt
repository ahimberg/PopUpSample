package com.example.popupsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Popup
import com.example.popupsample.ui.theme.PopUpSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopUpSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    GreetingPopUp("Android")
                }
            }
        }
    }
}

@Composable
fun GreetingPopUp(name: String) {
    var showpopup = remember { mutableStateOf(true) }
    Column() {
        Button({showpopup.value = true}) { Text("Show") }
        if (showpopup.value) {
            Popup(
                onDismissRequest = { showpopup.value = false}
            ) {
                Surface(color = Color.LightGray) {
                    Text(text = "Hello $name!", modifier = Modifier.semantics { testTag = "popup" })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PopUpSampleTheme {
        GreetingPopUp("Android")
    }
}