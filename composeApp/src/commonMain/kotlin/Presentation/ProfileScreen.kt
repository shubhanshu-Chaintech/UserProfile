@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class
)

package Presentation

import Presentation.components.GradientBackground
import Presentation.components.UserTextField
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.app.userprofile.Res
import network.chaintech.cmpimagepickncrop.CMPImagePickNCropDialog
import network.chaintech.cmpimagepickncrop.imagecropper.rememberImageCropper
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileScreenRoot(modifier: Modifier = Modifier) {

    ProfileScreen(
        state = ProfileState(

        ),
        onAction = { action ->
        }

    )
}

@Composable
fun ProfileScreen(
    state: ProfileState,
    onAction: (ProfileAction) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = {
                Text(
                    "Edit Profile",
                )
            }
            )
        }
    ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Box() {
                    Card(
                        onClick = { /* Handle Profile Picture Click */ },
                        shape = CircleShape,
                        modifier = Modifier.size(160.dp),
                        border = BorderStroke(width = 1.dp, color = Color.Blue)
                    ) {
                        IconButton(onClick = { /* Handle Profile Picture Click */ }) {
                            Icons.Filled.Add
                        }
                    }
                }


//                Image(painterResource(Res.drawable.))
                UserTextField(
                    state = state.username,
                    startIcon = Icons.Default.Person,
                    keyboardType = KeyboardType.Text,
                    hint = "",
                    title = ""
                )
                UserTextField(
                    state = state.email,
                    startIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Text,
                    hint = "",
                    title = ""
                )
                // Password
                UserTextField(
                    state = state.password,
                    startIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Text,
                    hint = "",
                    title = ""
                )
                // Date of Birth
                OutlinedTextField(
                    value = dateOfBirth,
                    onValueChange = { dateOfBirth = it },
                    label = { Text("Date of Birth") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                // Country/Region
                OutlinedTextField(
                    value = country,
                    onValueChange = { country = it },
                    label = { Text("Country/Region") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                // Save Changes Button
                Button(onClick = { /* Handle Save Changes */ }) {
                    Text("Save Changes")
                }
            }
        }
    }


@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    var selectedImage by remember { mutableStateOf<ImageBitmap?>(null) }
    val imageCropper = rememberImageCropper()
    var openImagePicker by remember { mutableStateOf(false) }
    CMPImagePickNCropDialog(
        imageCropper = imageCropper,
        cropEnable = false,
        openImagePicker = openImagePicker,
        showCameraOption = false,
        showGalleryOption = false,
        imagePickerDialogHandler = {
            openImagePicker = it
        },
        selectedImageCallback = {
            selectedImage = it
        }
    )
}

