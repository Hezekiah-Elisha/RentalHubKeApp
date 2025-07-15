package ke.hub.rentalhubke.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.components.OnboardingItem
import ke.hub.rentalhubke.model.Onboarding
import ke.hub.rentalhubke.navigation.ScreenRoutes
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme
import ke.hub.rentalhubke.utils.Constants
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val pages = Constants.pages
    OnboardingScreenContent(
        modifier=modifier,
        pages=pages
    ) {
        navController.navigate(ScreenRoutes.Login.route) {
            popUpTo("onboarding") {
                inclusive = true
            }
        }
    }
}

@Composable
fun OnboardingScreenContent(
    modifier: Modifier = Modifier,
    pages: List<Onboarding> = Constants.pages,
    toLogin: () -> Unit = { /* Navigate to login screen */ }
) {
    val pagerState = rememberPagerState (
        initialPage=0,
        pageCount = { pages.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment . CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(0.8f)
        ) { page ->
            OnboardingItem(page=pages[page], modifier = modifier)
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            repeat(pages.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(35.dp)
                        .height(8.dp)
                        .border(
                            width = 1.dp, color = if (isSelected) MaterialTheme.colorScheme.primary
                            else Color.Gray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .background(
                            color = if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.background, shape = CircleShape
                        )
                )
            }
        }
        if (pagerState.currentPage < pages.size - 1) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pages.size - 1 )
                        }
                    }
                ) {
                    Text(
                        text = "Skip",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Next"
                        )
//                        Icon(
//                            painter = painterResource(R.drawable.outline_1x_mobiledata_24),
//                            contentDescription = "Next",
//                        )
                    }
                }

            }
        } else {
//            CircleArc(modifier = Modifier.padding(16.dp), next = {
//                navController.navigate(Screens.Login.route){
//                    popUpTo(Screens.Onboarding.route) {
//                        inclusive = true
//                    }
//                }
//            })
            TextButton(
                onClick = {
                    toLogin()
                }
            ) {
                Text(
                    text = "Get Started"
                )
            }
        }

    }
}

@PreviewLightDark
@Composable
private fun OnboardingScreenPreview() {
    RentalHubKeTheme {
        OnboardingScreenContent()
    }
}