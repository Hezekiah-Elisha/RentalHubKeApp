package ke.hub.rentalhubke.ui.screens.auth

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.components.RhInput
import ke.hub.rentalhubke.components.RhInputWithLabel
import ke.hub.rentalhubke.navigation.ScreenRoutes
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    LoginScreenContent(
        modifier = modifier,
        toHome = {
            navController.navigate(ScreenRoutes.Home.route) {
                popUpTo("login") {
                    inclusive = true
                }
            }
        }
    )
}
@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    toRegister: () -> Unit = { /* Navigate to register screen */ },
    toForgotPassword: () -> Unit = { /* Navigate to forgot password screen */ },
    toHome: () -> Unit = { /* Navigate to home screen */ },
) {
    val context = LocalContext.current

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

    val googleSignInOptions = remember{
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
    }


    val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(true)
        .setServerClientId(context.getString(R.string.default_web_client_id))
        .setAutoSelectEnabled(true)
        .build()

    // Create the Credential Manager request
    val request = GetCredentialRequest.Builder()
        .addCredentialOption(googleIdOption)
        .build()

    Column (
        modifier = modifier.fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column (
            modifier = Modifier
                .weight(0.2f)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom)
        ){
            Text(
                text = "Rental Hub Ke",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = "Welcome back! Please login to your account.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        Column (
            modifier = Modifier
                .weight(0.8f)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ){
            Button(
                onClick = toHome
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
//                        .border(
//                            width = 1.dp,
//                            color = MaterialTheme.colorScheme.onSurfaceVariant,
//                            shape = MaterialTheme.shapes.large
//                        )
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
                        text = "Continue with Google",
                        style = MaterialTheme.typography.bodyLarge,
//                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "OR",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
//            AndroidView(modifier=Modifier.fillMaxWidth().height(48.dp),
//                factory = {context->
//                    SignInButton(context).apply {
//                        setSize(SignInButton.SIZE_WIDE)
//                        setOnClickListener {  }
//                    }
//                }
//            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            ) {
                RhInputWithLabel(
                    simpleLabel = "Email",
                ){
                    RhInput(
                        input = email.value,
                        onInputChanged = { email.value = it },
                        label = "Email",
                        placeholder = "Enter your email",
                        enabled = true,
                        imeAction = androidx.compose.ui.text.input.ImeAction.Next,
                        onImeAction = { controller?.hide() },
                        singleLine = true
                    )
                }
                RhInputWithLabel(
                    simpleLabel = "Password",
                ){
                    RhInput(
                        input = password.value,
                        onInputChanged = { password.value = it },
                        label = "Password",
                        placeholder = "Enter your password",
                        enabled = true,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                        onImeAction = { controller?.hide() },
                        singleLine = true,
                        passwordVisibility = passwordVisibility,
                        visualTransformation = if (passwordVisibility.value) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Forgot Password?",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { toForgotPassword() }
                    )
                    Text(
                        text = "Don't have an account? Register",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { toRegister() }
                    )
                }
                Button(
                    onClick = {
                        // Handle login logic here
                        Log.d("LoginScreen", "Login button clicked with email: ${email.value.text} and password: ${password.value.text}")
                        toHome()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                    )
                }
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