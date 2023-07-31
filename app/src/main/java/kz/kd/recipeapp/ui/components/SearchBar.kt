package kz.kd.recipeapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.kd.recipeapp.ui.theme.AppTheme

@Composable
fun SearchBar(
    textFieldValue: String,
    textFieldOnValueChange: (String) -> Unit,
    searchButtonOnClick: () -> Unit,
    searchButtonEnabled: Boolean,
    displayDensity: Float,
    modifier: Modifier = Modifier
) {
    var heightInDp by remember { mutableStateOf(0.dp) }

    Surface(
        shape = RoundedCornerShape(size = 24.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        ),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBarField(
                textFieldValue = textFieldValue,
                textFieldOnValueChange = textFieldOnValueChange,
                textFieldOnSizeChanged = { intSize ->
                    heightInDp = (intSize.height / displayDensity).dp
                },
                modifier = Modifier
                    .weight(1f)
            )

            SearchButton(
                searchButtonOnClick = searchButtonOnClick,
                searchButtonEnabled = searchButtonEnabled,
                modifier = Modifier
                    .heightIn(min = heightInDp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    var textFieldValue by remember { mutableStateOf("") }
    val displayDensity = LocalDensity.current.density
    AppTheme {
        SearchBar(
            textFieldValue = textFieldValue,
            textFieldOnValueChange = { newValue -> textFieldValue = newValue },
            searchButtonOnClick = { /*TODO*/ },
            searchButtonEnabled = true,
            displayDensity = displayDensity
        )
    }
}