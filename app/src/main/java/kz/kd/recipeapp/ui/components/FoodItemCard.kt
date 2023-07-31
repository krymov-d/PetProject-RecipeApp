package kz.kd.recipeapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kz.kd.recipeapp.R
import kz.kd.recipeapp.domain.models.FoodItem

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FoodItemCard(
    foodItem: FoodItem,
    modifier: Modifier = Modifier
) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.secondaryContainer,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            GlideImage(
                model = foodItem.image,
                contentDescription = foodItem.label,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(size = 96.dp)
            )

            Column(
                modifier = Modifier
            ) {
                Text(
                    text = foodItem.label,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )

                Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

                Text(
                    text = stringResource(R.string.placeholder_cal, foodItem.calories),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}