package ke.hub.rentalhubke.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.navigation.ScreenRoutes
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    SplashScreenContent(
        modifier = modifier,
        destination = {
            navController.navigate(ScreenRoutes.Onboarding.route){
                popUpTo(ScreenRoutes.Splash.route) {
                    inclusive = true
                }
            }
        }
    )
}

@Composable
fun SplashScreenContent(
    modifier: Modifier = Modifier,
    destination: () -> Unit = {}
) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        destination()
    }
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Image(
//                painter = painterResource(R.drawable.outline_1x_mobiledata_24),
//                contentDescription = "Hakiba Logo"
//            )
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = "Rental Hub KE",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 66.sp
            )
        }
    }

}

@PreviewLightDark
@Composable
private fun SplashScreenPreview() {
    RentalHubKeTheme {
        SplashScreenContent()
    }
}