package ke.hub.rentalhubke.ui.screens.property

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.components.RhTopBar
import ke.hub.rentalhubke.model.Property
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun PropertyScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val property = Property(
        id="1",
        title="Jomoko, Thika",
        description="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price=1000.0,
        location = "Nairobi",
        imageRes = R.drawable.krzysztof,
        isBookmarked = false
    )
    PropertyScreenContent(
        modifier = Modifier,
        property = property,
    )
}

@Composable
fun PropertyScreenContent(
    modifier: Modifier = Modifier,
    property: Property = Property(id="1", title="Jomoko, Thika", description="Location 1", price=1000.0, location = "Nairobi", imageRes = R.drawable.krzysztof, isBookmarked = false)
) {
    Scaffold (
        modifier = modifier.fillMaxSize(),
        topBar = {
            RhTopBar()
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Button(
                    onClick = {},
                    modifier = Modifier.weight(0.75f)
                ) {
                    Text(
                        text="Call Owner"
                    )
                }
                IconButton(
                    onClick = { /* Handle bookmark action */ },
                    modifier = Modifier.padding(start = 8.dp)
                        .weight(0.25f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark_24dp_ffffff_fill0_wght400_grad0_opsz24),
                        contentDescription = "Bookmark Icon",
                    )
                }
            }
        }
    ){ innerPadding->
        Column (
            modifier=Modifier.fillMaxWidth()
                .padding(innerPadding)
        ){
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.BottomEnd
            ){
                Image(
                    painter = painterResource(property.imageRes),
                    contentDescription = "Property Image",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd)
                        .offset(y = 40.dp)
                        .background(
//                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                            color = MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.small
                        ),
                    onClick = {
                        // Handle image click action, e.g., open a full-screen image viewer
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.play_arrow_24dp_ffffff_fill0_wght400_grad0_opsz24),
                        contentDescription = "Play Video Icon",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            Text(
                text = property.title,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = property.description,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PropertyScreenPreview() {
    RentalHubKeTheme {
        PropertyScreenContent()
    }
}