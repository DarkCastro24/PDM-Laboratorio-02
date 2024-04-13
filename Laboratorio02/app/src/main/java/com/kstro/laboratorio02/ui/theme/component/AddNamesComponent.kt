package com.kstro.laboratorio02.ui.theme.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kstro.laboratorio02.ui.theme.data.buttonStatus
import com.kstro.laboratorio02.ui.theme.data.nameList


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddNamesComponent() {
    val nameListScope = remember { nameList }
    var showDialog by remember { mutableStateOf(false) }
    val name: MutableState<String> = remember { mutableStateOf("") }
    val buttonsScope = remember { buttonStatus }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirmation alert") },
            text = { Text("Do you want to delete all the names?") },
            confirmButton = {
                Button(onClick = {
                    nameListScope.clear()
                    showDialog = false
                }) {
                    Text("Continue")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You can add more names on this text field",
            modifier = Modifier.padding(vertical = 6.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = { newValue -> // Spaces of \n and validations
                if (!newValue.contains("\n") && !newValue.contains(" ")) {
                    name.value = newValue
                } else {
                    name.value = newValue.filterNot { it == '\n' || it == ' ' }
                }
            },
            singleLine = true,
            placeholder = { Text(text = "Enter the name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true
            )
        )
        Button(
            enabled = buttonsScope.value,
            onClick = {
                nameList.add(name.value)
                name.value = ""
                Log.d("Name List", nameListScope.toString())
            },
            modifier = Modifier.padding(vertical = 6.dp)
        ) {
            Text(text = "Add name")
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black)
                .height(250.dp)
                .padding(horizontal = 4.dp)
        ) {
            itemsIndexed(nameListScope) { index, nameToIndexed ->
                Text(text = "Name #${index + 1}: $nameToIndexed",
                    modifier = Modifier
                        .padding(4.dp)
                        .background(
                            Color(0xFF003366),
                            shape = RoundedCornerShape(10.dp) // Douglas Style
                        )
                        .padding(4.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
            }
        }

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Clean list")
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun AddNamesComponentPreview() {
    AddNamesComponent()
}