package ke.hub.rentalhubke

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ke.hub.rentalhubke.navigation.AppNavigation
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentalHubKeTheme {
                AppNavigation()
            }
        }
    }
}