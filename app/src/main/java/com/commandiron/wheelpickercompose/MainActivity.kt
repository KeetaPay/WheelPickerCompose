package com.commandiron.wheelpickercompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.commandiron.wheel_picker_compose.*
import com.commandiron.wheel_picker_compose.wheel_picker.WheelPicker
import com.commandiron.wheel_picker_compose.wheel_picker.WheelPickerDefaults
import com.commandiron.wheelpickercompose.ui.theme.WheelPickerComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WheelPickerComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WheelPicker(
                            count = 6,
                            onScrollFinished = { snappedIndex ->
                                println(snappedIndex)
                                snappedIndex
                            },
                            selectorAttr = WheelPickerDefaults.selectorDefaults(
                                enabled = true
                            ),
                        ) { index ->
                            Text(text = "Test $index")
                        }
                    }
                }
            }
        }
    }
}