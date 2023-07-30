package kz.kd.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kz.kd.recipeapp.components.SearchBar
import kz.kd.recipeapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
) {
    var textFieldValue by remember { mutableStateOf("") }
    val isTextEntered by remember {
        derivedStateOf {
            textFieldValue.isNotBlank()
        }
    }
    val displayDensity = LocalDensity.current.density

    SearchBar(
        textFieldValue = textFieldValue,
        textFieldOnValueChange = { newValue -> textFieldValue = newValue },
        searchButtonOnClick = { /*TODO*/ },
        searchButtonEnabled = isTextEntered,
        displayDensity = displayDensity,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
}