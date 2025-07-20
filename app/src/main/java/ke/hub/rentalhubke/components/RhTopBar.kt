package ke.hub.rentalhubke.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RhTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_backward_24dp_ffffff_fill0_wght400_grad0_opsz24),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        title = {
            Text(
                text = "Property",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        scrollBehavior = null
    )
}

@PreviewLightDark
@Composable
fun RhTopBarPreview(modifier: Modifier = Modifier) {
    RentalHubKeTheme {
        RhTopBar(modifier = modifier)
    }
}