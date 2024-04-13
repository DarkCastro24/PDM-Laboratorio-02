package com.kstro.laboratorio02.ui.theme.component

import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.kstro.laboratorio02.ui.theme.data.buttonStatus

@Composable
fun DisableOptionButton() {
    val dialogStatus: MutableState<Boolean> = remember { mutableStateOf(false) }
    val buttonsScope = remember {
        buttonStatus
    }

    Button(onClick = {
        dialogStatus.value = !dialogStatus.value
    }) {
        Text(text = if (buttonsScope.value) "Disable buttons" else "Enable buttons")
    }
    if (dialogStatus.value) {
        AlertDialog(onDismissRequest = { dialogStatus.value = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false
            ),
            confirmButton = {
                Button(onClick = {
                    Log.d("BEFORE", "$buttonStatus" + "$buttonsScope")
                    buttonStatus.value = !buttonStatus.value
                    Log.d("AFTER", "$buttonStatus" + "$buttonsScope")
                    dialogStatus.value = false
                }) {
                    Text(text = "Confirm")

                }
            },
            dismissButton = {
                Button(onClick = {
                    dialogStatus.value = false
                }) {
                    Text(text = "Cancel")
                }
            },
            text = { Text(text = if (buttonsScope.value) "Disable buttons" else "Enable buttons") },
            title = { Text(text = "Confirmation") }
        )
    }
}

@Preview(showSystemUi = false)
@Composable
private fun DisableOptionButtonPreview() {
    DisableOptionButton()
}