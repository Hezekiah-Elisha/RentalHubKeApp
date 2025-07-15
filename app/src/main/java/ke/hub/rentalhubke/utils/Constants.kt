package ke.hub.rentalhubke.utils

import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.model.Onboarding

class Constants {
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
    }
}