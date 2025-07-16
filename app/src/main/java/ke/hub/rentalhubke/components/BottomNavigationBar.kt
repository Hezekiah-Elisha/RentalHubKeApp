package ke.hub.rentalhubke.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme
import ke.hub.rentalhubke.utils.Constants

@Composable
fun BottomNavigationBar(
    navController: NavController = rememberNavController(),
) {
    val items = Constants.NAVITEMS
    var selectedItemIndex by rememberSaveable {
        mutableStateOf("home")
    }

    NavigationBar(
        tonalElevation = 4.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEachIndexed { _, navItems ->
            NavigationBarItem(
                selected = currentRoute == navItems.route,
                onClick = {
                    selectedItemIndex = navItems.route
                    navController.navigate(navItems.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            selectedItemIndex = navItems.route
                        }
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = true,
                icon = {
                    (if (currentRoute == navItems.route) navItems.selectedIcon else navItems.unselectedIcon).let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = navItems.title,
//                            tint = if (currentRoute == navItems.route) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                        )
                    }
                },
                label = {
                    Text(
                        text = navItems.title,
                        fontWeight = if (currentRoute == navItems.route) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun BottomNavPreview() {
    RentalHubKeTheme {
        BottomNavigationBar(navController = rememberNavController())
    }
}