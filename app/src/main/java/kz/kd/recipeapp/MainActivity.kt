package kz.kd.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kz.kd.recipeapp.ui.components.FoodItemCard
import kz.kd.recipeapp.ui.components.SearchBar
import kz.kd.recipeapp.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val vmMain: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyApp(viewModel = vmMain)
            }
        }
    }
}

@Composable
fun MyApp(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val isTextEntered by remember {
        derivedStateOf {
            viewModel.searchValue.value.isNotBlank()
        }
    }
    val displayDensity = LocalDensity.current.density

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            SearchBar(
                textFieldValue = viewModel.searchValue.value,
                textFieldOnValueChange = { newValue -> viewModel.textFieldOnValueChange(newValue) },
                searchButtonOnClick = { viewModel.getFoodItems() },
                searchButtonEnabled = isTextEntered,
                displayDensity = displayDensity,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(space = 4.dp),
                contentPadding = PaddingValues(bottom = 8.dp),
                modifier = modifier
            ) {
                items(items = viewModel.foodItemsList.value) { foodItem ->
                    FoodItemCard(
                        foodItem = foodItem,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}