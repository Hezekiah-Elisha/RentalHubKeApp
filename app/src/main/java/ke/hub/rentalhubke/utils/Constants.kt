package ke.hub.rentalhubke.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.model.NavItems
import ke.hub.rentalhubke.model.Onboarding
import ke.hub.rentalhubke.navigation.ScreenRoutes

class Constants {

    fun restartApp(
        context: Context,
        info : String = "Logged out successfully"
    ) {
        val intent = context.packageManager
            .getLaunchIntentForPackage(context.packageName)
            ?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        context.startActivity(intent)
        (context as Activity).finishAffinity()
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val pages = listOf(
            Onboarding(
                title = "Welcome to Rental Hub Ke",
                description = "You rental journey starts here. Discover, save, and manage your rentals with ease.",
                imageRes = R.drawable.undraw_destination_fkst
            ),
            Onboarding(
                title = "Find Your Perfect Rental",
                description = "Browse through a wide range of rental properties tailored to your needs.",
                imageRes = R.drawable.undraw_house_searching_g2b8
            ),
            Onboarding(
                title = "Perfect home for you",
                description = "Explore a variety of rental options that suit your lifestyle and budget.",
                imageRes = R.drawable.undraw_apartment_rent_oodr
            ),
            Onboarding(
                title = "Find fast and easy",
                description = "Experience a seamless rental process with quick listings and easy navigation.",
                imageRes = R.drawable.undraw_select_house_l2l0
            )
        )

        val NAVITEMS = listOf(
            NavItems(
                title = "Home",
                route = ScreenRoutes.Home.route,
                selectedIcon = R.drawable.home_24dp_ffffff_fill1_wght400_grad0_opsz24,
                unselectedIcon = R.drawable.home_24dp_ffffff_fill0_wght400_grad0_opsz24
            ),
            NavItems(
                title = "Bookmarks",
                route = ScreenRoutes.Bookmarks.route,
                selectedIcon = R.drawable.bookmark_24dp_ffffff_fill1_wght400_grad0_opsz24,
                unselectedIcon = R.drawable.bookmark_24dp_ffffff_fill0_wght400_grad0_opsz24
            ),
            NavItems(
                title = "Profile",
                route = ScreenRoutes.Profile.route,
                selectedIcon = R.drawable.account_circle_24dp_ffffff_fill1_wght400_grad0_opsz24,
                unselectedIcon = R.drawable.account_circle_24dp_ffffff_fill0_wght400_grad0_opsz24
            ),
//            NavItems(
//                title = "Groups",
//                route = Screens.Groups.route,
//                selectedIcon = R.drawable.baseline_groups_24,
//                unselectedIcon = R.drawable.outline_groups_24
//            )
        )
    }
}