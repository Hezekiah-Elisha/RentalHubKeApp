package ke.hub.rentalhubke.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    HomeScreenContent(modifier=modifier)
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
) {
    // Content for the Home Screen will be implemented here
    // This could include a list of properties, search functionality, etc.
    Column (
        modifier= modifier.fillMaxSize()
    ){
        Text("This is home screen content")
    }
}

@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    RentalHubKeTheme {
        HomeScreenContent()
    }
}