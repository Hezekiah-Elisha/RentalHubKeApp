package ke.hub.rentalhubke.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    ProfileScreenContent(modifier=modifier)
}
@Composable
fun ProfileScreenContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text("This is Profile screen content")
    }
}

@PreviewLightDark
@Composable
fun ProfileScreenPreview() {
    // This function can be used to preview the BookmarksScreenContent
    // in the Android Studio preview window.
    ProfileScreenContent()
}