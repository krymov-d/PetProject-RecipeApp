package kz.kd.recipeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kz.kd.recipeapp.ui.theme.AppTheme

@Composable
fun SearchButton(
    searchButtonOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = searchButtonOnClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun SearchButtonPreview() {
    AppTheme {
        SearchButton(searchButtonOnClick = {})
    }
}