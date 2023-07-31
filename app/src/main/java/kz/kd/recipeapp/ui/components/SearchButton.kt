package kz.kd.recipeapp.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kz.kd.recipeapp.ui.theme.AppTheme

@Composable
fun SearchButton(
    searchButtonOnClick: () -> Unit,
    searchButtonEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = searchButtonOnClick,
        enabled = searchButtonEnabled,
        shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50),
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchButtonPreview() {
    AppTheme {
        SearchButton(
            searchButtonOnClick = {},
            searchButtonEnabled = true,
        )
    }
}