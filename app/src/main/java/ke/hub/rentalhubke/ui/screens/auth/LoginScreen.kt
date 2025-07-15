package ke.hub.rentalhubke.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    LoginScreenContent()
}
@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    toRegister: () -> Unit = { /* Navigate to register screen */ },
    toForgotPassword: () -> Unit = { /* Navigate to forgot password screen */ }
) {
    val controller = LocalSoftwareKeyboardController.current
    val email = remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    val password = remember {
        mutableStateOf(
            TextFieldValue("")
        )
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    Column (
        modifier = modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column (
            modifier = modifier
                .weight(0.2f)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainerLow,
                    shape = MaterialTheme.shapes.large
                ).padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom)
        ){
            Text(
                text = "Login".uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = "Welcome back! Please login to your account.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Column (
            modifier = modifier.weight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ){
            Row (
                modifier = modifier.fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Image(
                    painter = painterResource(id = R.drawable.google_icon_logo),
                    contentDescription = "Google Icon",
                    modifier = Modifier
                        .height(24.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Login with Google",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun LoginScreenPreview() {
    RentalHubKeTheme {
        LoginScreenContent()
    }
}