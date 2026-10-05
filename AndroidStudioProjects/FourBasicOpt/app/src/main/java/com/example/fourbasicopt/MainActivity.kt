package com.example.fourbasicopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fourbasicopt.ui.theme.FourBasicOptTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FourBasicOptTheme {
                Calculator()
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun Calculator() {

    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Four Basic Operations"
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Number 1") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Number 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = {
                    val a = number1.toDoubleOrNull()
                    val b = number2.toDoubleOrNull()

                    if (a != null && b != null) {
                        result = (a + b).toString()
                    } else {
                        result = "Enter valid numbers"
                    }
                }
            ) {
                Text("+")
            }

            Button(
                onClick = {
                    val a = number1.toDoubleOrNull()
                    val b = number2.toDoubleOrNull()

                    if (a != null && b != null) {
                        result = (a - b).toString()
                    } else {
                        result = "Enter valid numbers"
                    }
                }
            ) {
                Text("-")
            }

            Button(
                onClick = {
                    val a = number1.toDoubleOrNull()
                    val b = number2.toDoubleOrNull()

                    if (a != null && b != null) {
                        result = (a * b).toString()
                    } else {
                        result = "Enter valid numbers"
                    }
                }
            ) {
                Text("×")
            }

            Button(
                onClick = {
                    val a = number1.toDoubleOrNull()
                    val b = number2.toDoubleOrNull()

                    if (a != null && b != null) {
                        if (b == 0.0) {
                            result = "Cannot divide by zero"
                        } else {
                            result = (a / b).toString()
                        }
                    } else {
                        result = "Enter valid numbers"
                    }
                }
            ) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Result: $result"
        )
    }
}