package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import models.Products
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun ListScreen(list: List<Products>)
{
    LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp)) {
        items(list) { data ->
            ColumnItem(data.title, data.description, data.price.toString(), data.thumbnail)
        }
    }
}

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun ColumnItem(name: String, description: String, price:String, image: String) {
        Card(
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                KamelImage(
                    resource = asyncPainterResource(data = image),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
                Column(Modifier.padding(4.dp)) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = name,
                        maxLines = 3,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = description,
                        maxLines = 3,
                        style = MaterialTheme.typography.body2,
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = "Price USD $price",
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }
    }