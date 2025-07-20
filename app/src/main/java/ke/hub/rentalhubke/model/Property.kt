package ke.hub.rentalhubke.model

data class Property(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val location: String,
    val imageRes: Int,
    val isBookmarked: Boolean = false
)
