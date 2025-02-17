package com.kstro.laboratorio02.ui.theme.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kstro.laboratorio02.ui.theme.data.buttonStatus

@Composable
fun ModifyTextComponent() {


    val pressedCounter: MutableState<Int> = remember {
        mutableStateOf(0)
    }

    val buttonsScope = remember {
        buttonStatus
    }
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "The button has been pressed ${pressedCounter.value} times")
        Button(
            enabled = buttonsScope.value,
            onClick = {
                pressedCounter.value++
            }

        ) {
            Text(text = "Increase counter")
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun ModifyTextComponentPreview() {
    ModifyTextComponent()
}