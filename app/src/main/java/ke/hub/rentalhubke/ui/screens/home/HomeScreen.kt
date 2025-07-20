package ke.hub.rentalhubke.ui.screens.home

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.model.Property
import ke.hub.rentalhubke.navigation.ScreenRoutes
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    HomeScreenContent(
        modifier=modifier,
        toApartmentDetails = {
            navController.navigate(ScreenRoutes.PropertyDetails.route)
        }
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    toApartmentDetails: (Property) -> Unit = { Log.d("Apartment Clicked", it.title) }
) {
    var searchText by remember { mutableStateOf(TextFieldState()) }
    val searchResults = listOf("Property 1", "Property 2", "Property 3") // Example search results

    val categories = listOf(
        "All",
        "Houses",
        "Apartments",
        "Commercial",
        "Land"
    )
    val apartments = listOf(
        Property(id="Jomoko, Thika", title="Jomoko, Thika", description="Location 1", price=1000.0, location = "Nairobi", imageRes = R.drawable.krzysztof, isBookmarked = false),
        Property(id="Utawala, Nairobi", title="Utawala, Nairobi", description="Location 2", price=1200.0, location = "Mombasa", imageRes = R.drawable.krzysztof, isBookmarked = false),
        Property(id="Kayole, Nairobi", title="Kayole, Nairobi", description="Location 3", price=1500.0, location = "Kisumu", imageRes = R.drawable.krzysztof, isBookmarked = false)
    )

    Column (
        modifier= modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ){
        Text(
            text = "Rental Hub Ke",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth()
        )
        SimpleSearchBar(
            textFieldState = searchText,
            onSearch = { query ->
                // Handle search logic here, e.g., filter properties based on query
                println("Searching for: $query")
            },
            searchResults = searchResults,
            modifier = Modifier.fillMaxWidth()
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
        ) {
            items(categories.size) { index ->
                SuggestionChip(
                    onClick = { Log.d("Suggestion chip", "hello world") },
                    label = { Text(categories[index]) },
                )
            }
        }
        ApartmentsSection(
            onApartmentClick = toApartmentDetails,
            apartments = apartments,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    // Controls expansion state of the search bar
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
//            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = { textFieldState.edit { replace(0, length, it) } },
                    onSearch = {
                        onSearch(textFieldState.text.toString())
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Search") },
                    leadingIcon = {
                        AnimatedContent(targetState = textFieldState.text.isEmpty()) { isEmpty ->
                            if (isEmpty) {
                                Icon(
                                    painterResource(R.drawable.search_24dp_ffffff_fill0_wght400_grad0_opsz24),
                                    contentDescription = "Search Icon",
                                )
                            } else {
                                Icon(
                                    painterResource(R.drawable.close_24dp_ffffff_fill0_wght400_grad0_opsz24),
                                    contentDescription = "Search Icon",
                                )
                            }
                        }
                    }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            // Display search results in a scrollable column
            Column(Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        modifier = Modifier
                            .clickable {
                                textFieldState.edit { replace(0, length, result) }
                                expanded = false
                            }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ApartmentsSection(
    modifier: Modifier = Modifier,
    apartments: List<Property>,
    onApartmentClick: (Property) -> Unit = { Log.d("Apartment Clicked", it.title) }
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(apartments.size) { index ->
                ApartmentItem(
                    property = apartments[index],
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onApartmentClick
                )
            }
        }
    }
}

@Composable
fun ApartmentItem(
    modifier: Modifier = Modifier,
    property: Property,
    onClick: (Property) -> Unit = { Log.d("Apartment Clicked", it.title) }
) {
    val bookmark = rememberSaveable { mutableStateOf(property.isBookmarked) }
    Card (
        modifier = Modifier
            .fillMaxWidth()
//                        .padding(8.dp)
            .clickable {
                onClick(property)
                Log.d("Apartment Clicked", property.title)
            },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
    ){
        Box(
            modifier = modifier
        ){
            Image(
                painter = painterResource(property.imageRes),
                contentDescription = property.title,
            )
            IconButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .semantics { traversalIndex = 1f },
                onClick = {
                    bookmark.value = !bookmark.value
                    Log.d("Bookmark Clicked", "Property: ${property.title}, Bookmarked: ${bookmark.value}")
                }
            ) {
                if (bookmark.value){
                    Icon(
                        painter = painterResource(R.drawable.bookmark_24dp_ffffff_fill1_wght400_grad0_opsz24),
                        contentDescription = "Bookmark Icon",
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.bookmark_24dp_ffffff_fill0_wght400_grad0_opsz24),
                        contentDescription = "Bookmark Icon",
                    )
                }
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
//                    .padding(16.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    )
            ) {
                Column (
                    modifier = modifier.padding(16.dp)
                ){
                    Text(
                        text = property.title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = property.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = "Ksh ${property.price}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}


@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    RentalHubKeTheme {
        HomeScreenContent()
    }
}