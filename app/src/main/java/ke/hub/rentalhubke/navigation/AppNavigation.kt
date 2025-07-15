package ke.hub.rentalhubke.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.ui.screens.auth.LoginScreen
import ke.hub.rentalhubke.ui.screens.onboarding.OnboardingScreen
import ke.hub.rentalhubke.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: String = ScreenRoutes.Splash.route
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(ScreenRoutes.Splash.route){
             SplashScreen(navController = navController)
        }
        composable(ScreenRoutes.Onboarding.route) {
             OnboardingScreen(navController = navController)
        }
        composable(ScreenRoutes.Login.route) {
             LoginScreen(navController = navController)
        }
    }
}