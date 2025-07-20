package ke.hub.rentalhubke.ui.screens.property

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.MediaItem

@Composable
fun PropertyVideoScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }
//    video is in the res.raw folder, so we can use the resource ID to create a URI.
    val mediaItem = MediaItem.fromUri(
        "asset:///android_res/raw/test.mp4"
    )
}