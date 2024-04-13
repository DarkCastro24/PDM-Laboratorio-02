package com.kstro.laboratorio02.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kstro.laboratorio02.ui.theme.component.AddNamesComponent
import com.kstro.laboratorio02.ui.theme.component.DisableOptionButton
import com.kstro.laboratorio02.ui.theme.component.ModifyTextComponent

@Composable
fun HomeScreen(){
    Column (
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //ModifyTextComponent() No es solicitado en las indicaciones
        AddNamesComponent()
        DisableOptionButton()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview(){
    HomeScreen()
}