package ke.hub.rentalhubke.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.model.Onboarding
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun OnboardingItem(
    modifier: Modifier = Modifier,
    page: Onboarding
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp).fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = "Onboarding Image",
            modifier = modifier.padding(16.dp)
                .weight(1f)
        )
        Column (
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier= modifier.fillMaxWidth(),
                text = page.title,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                modifier= modifier.fillMaxWidth(),
                text = page.description,
                style = MaterialTheme.typography.labelLarge,
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                textAlign = TextAlign.Center
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun OnBoardingItemPreview() {
    RentalHubKeTheme {
        OnboardingItem(
            page = Onboarding(
                title = "Welcome To Rental Hub KE",
                description = "Your journey to smarter savings and quick loans starts here.",
                imageRes = R.drawable.undraw_destination_fkst
            )
        )
    }
}