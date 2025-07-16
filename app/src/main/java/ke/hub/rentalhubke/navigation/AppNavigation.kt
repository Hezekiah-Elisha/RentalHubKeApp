package ke.hub.rentalhubke.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.components.BottomNavigationBar
import ke.hub.rentalhubke.ui.screens.auth.LoginScreen
import ke.hub.rentalhubke.ui.screens.bookmarks.BookmarksScreen
import ke.hub.rentalhubke.ui.screens.home.HomeScreen
import ke.hub.rentalhubke.ui.screens.onboarding.OnboardingScreen
import ke.hub.rentalhubke.ui.screens.profile.ProfileScreen
import ke.hub.rentalhubke.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: String = ScreenRoutes.Splash.route
) {
    val navController = rememberNavController()
    val showBottomBar = rememberSaveable { mutableStateOf(true) }

    Scaffold (
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar.value) {
                BottomNavigationBar(navController = navController)
            }
        }
    ){innerPadding->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 800),
                )
            },
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 800),
                )
            }
        ){
            composable(ScreenRoutes.Splash.route){
                showBottomBar.value =  false
                SplashScreen(
                    modifier=modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable(ScreenRoutes.Onboarding.route) {
                showBottomBar.value =  false
                OnboardingScreen(
                    modifier=modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable(ScreenRoutes.Login.route) {
                LoginScreen(
                    modifier=modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable(ScreenRoutes.Home.route) {
                showBottomBar.value =  true
                HomeScreen(
                    modifier=modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable(ScreenRoutes.Profile.route) {
                showBottomBar.value =  true
                 ProfileScreen(
                     modifier=modifier.padding(innerPadding),
                     navController = navController
                 )
            }
            composable(ScreenRoutes.Bookmarks.route) {
                showBottomBar.value =  true
                BookmarksScreen(
                    modifier=modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }
    }
}