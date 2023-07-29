package kz.kd.recipeapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kz.kd.recipeapp.ui.theme.AppTheme

@Composable
fun SearchBar(
    textFieldValue: String,
    textFieldOnValueChange: (String) -> Unit,
    searchButtonOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        SearchBarField(
            textFieldValue = textFieldValue,
            textFieldOnValueChange = textFieldOnValueChange,
            modifier = Modifier
                .weight(1f)
        )

        SearchButton(searchButtonOnClick = searchButtonOnClick)
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    var textFieldValue by remember { mutableStateOf("") }
    AppTheme {
        SearchBar(
            textFieldValue = textFieldValue,
            textFieldOnValueChange = { newValue -> textFieldValue = newValue },
            searchButtonOnClick = { /*TODO*/ })
    }
}