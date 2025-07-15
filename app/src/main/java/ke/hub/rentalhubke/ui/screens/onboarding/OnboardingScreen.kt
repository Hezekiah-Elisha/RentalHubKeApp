package ke.hub.rentalhubke.ui.screens.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    OnboardingScreenContent()
}

@Composable
fun OnboardingScreenContent(modifier: Modifier = Modifier) {
    
}

@PreviewLightDark
@Composable
private fun OnboardingScreen() {
    RentalHubKeTheme {
        OnboardingScreenContent()
    }
}