package ke.hub.rentalhubke.utils

import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.model.Onboarding

class Constants {
    companion object {
        val pages = listOf(
            Onboarding(
                title = "Welcome to Hakiba",
                description = "Your journey to smarter savings and quick loans starts here.",
                imageRes = R.drawable.undraw_destination_fkst
            ),
            Onboarding(
                title = "Save with Purpose",
                description = "Set goals and watch your savings grow. Hakiba helps you save for what matters most.",
                imageRes = R.drawable.undraw_house_searching_g2b8
            ),
            Onboarding(
                title = "Track and Celebrate Progress",
                description = "Stay motivated with real-time insights and rewards.",
                imageRes = R.drawable.undraw_apartment_rent_oodr
            ),
            Onboarding(
                title = "Your Money is Safe with Us",
                description = "Built on trust, powered by security. You get transparency and accountability.",
                imageRes = R.drawable.undraw_select_house_l2l0
            )
        )
    }
}