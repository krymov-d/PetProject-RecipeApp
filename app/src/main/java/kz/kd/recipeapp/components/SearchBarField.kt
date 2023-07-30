package kz.kd.recipeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import kz.kd.recipeapp.R
import kz.kd.recipeapp.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarField(
    textFieldValue: String,
    textFieldOnValueChange: (String) -> Unit,
    textFieldOnSizeChanged: (IntSize) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = textFieldValue,
        onValueChange = textFieldOnValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = stringResource(id = R.string.placeholder_search),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = modifier
            .onSizeChanged { intSize -> textFieldOnSizeChanged(intSize) }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarFieldPreview() {
    var textFieldValue by remember { mutableStateOf("") }
    AppTheme {
        SearchBarField(
            textFieldValue = textFieldValue,
            textFieldOnValueChange = { newValue -> textFieldValue = newValue },
            textFieldOnSizeChanged = { }
        )
    }
}