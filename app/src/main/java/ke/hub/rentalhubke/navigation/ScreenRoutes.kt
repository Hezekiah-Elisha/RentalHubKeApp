package ke.hub.rentalhubke.navigation

sealed class ScreenRoutes (val route: String) {
    object Splash : ScreenRoutes("splash")
    object Onboarding : ScreenRoutes("onboarding")
    object Login : ScreenRoutes("login")
    object Register : ScreenRoutes("register")
    object Home : ScreenRoutes("home")
    object Profile : ScreenRoutes("profile")
    object Bookmarks : ScreenRoutes("bookmarks")
    object PropertyDetails : ScreenRoutes("property_details/{propertyId}") {
        fun createRoute(propertyId: String) = "property_details/$propertyId"
    }
    object Search : ScreenRoutes("search")
}