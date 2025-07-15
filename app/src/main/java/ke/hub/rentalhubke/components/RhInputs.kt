package ke.hub.rentalhubke.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.hub.rentalhubke.R
import ke.hub.rentalhubke.ui.theme.RentalHubKeTheme


@Composable
fun RhInput(
    modifier: Modifier = Modifier,
    input: TextFieldValue,
    onInputChanged: (TextFieldValue) -> Unit,
    label: String = "",
    enabled: Boolean = true,
    placeholder: String = "Enter Placeholder Description here",
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {},
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    passwordVisibility: MutableState<Boolean>? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = input,
        onValueChange = onInputChanged,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        enabled = enabled,
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold),
        singleLine = singleLine,
        minLines = if (singleLine) 1 else 3,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions( onDone = { onImeAction() } ),
        visualTransformation =visualTransformation,
        trailingIcon = {
            passwordVisibility?.let {
                val icon = if (it.value) {
                    painterResource(id = R.drawable.visibility_off_24dp_ffffff)
                } else {
                    painterResource(id = R.drawable.visibility_24dp_ffffff)
                }
                IconButton(onClick = { it.value = !it.value }) {
                    Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
                }
            }
        }
    )
}

@Composable
fun RhInputWithLabel(
    modifier: Modifier = Modifier,
    simpleLabel: String = "Label",
    content : @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(simpleLabel, style = MaterialTheme.typography.bodyMedium)
        content()
    }
}

@PreviewLightDark
@Composable
private fun HakibaInputPreview() {
    RentalHubKeTheme {
        RhInputWithLabel(
            simpleLabel = "Email"
        ){
            RhInput(
                input = TextFieldValue(),
                onInputChanged = {},
                label = "Email",
                placeholder = "Enter your email",
                enabled = true,
                imeAction = ImeAction.Next,
                onImeAction = {},
                singleLine = true,
                keyboardType = KeyboardType.Email,
                passwordVisibility = null
            )
        }
    }
}