package kz.kd.recipeapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kz.kd.recipeapp.R
import kz.kd.recipeapp.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarField(
    textFieldValue: String,
    textFieldOnValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = textFieldValue,
        onValueChange = textFieldOnValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        placeholder = {
                      Text(text = stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun SearchBarFieldPreview() {
    var textFieldValue by remember { mutableStateOf("Hello") }
    AppTheme {
        SearchBarField(
            textFieldValue = textFieldValue,
            textFieldOnValueChange = { newValue -> textFieldValue = newValue })
    }
}