@file:OptIn(ExperimentalFoundationApi::class)

package Presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class ProfileState(
    val username:TextFieldState = TextFieldState(),
    val email:TextFieldState = TextFieldState(),
    val password:TextFieldState = TextFieldState(),
)
