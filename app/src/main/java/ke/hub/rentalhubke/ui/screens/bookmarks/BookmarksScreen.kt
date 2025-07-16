package ke.hub.rentalhubke.ui.screens.bookmarks

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
fun BookmarksScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    BookmarksScreenContent(modifier=modifier)
}
@Composable
fun BookmarksScreenContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text("This is bookmarks screen content")
    }
}

@PreviewLightDark
@Composable
fun BookmarksScreenPreview() {
    RentalHubKeTheme {
        BookmarksScreenContent()
    }
}