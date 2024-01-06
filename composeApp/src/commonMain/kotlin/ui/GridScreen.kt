package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import models.Products
import org.jetbrains.compose.resources.ExperimentalResourceApi


@Composable
fun GridScreen(list: List<Products>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(list.size) { index ->
                val data = list[index]
                ProductItem(data.title, data.description, data.price.toString(), data.discountPercentage.toString(), data.thumbnail)
            }
        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProductItem(name: String, description: String, price: String, discount: String, image: String) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Column(modifier = Modifier.height(370.dp).padding(10.dp)) {
            KamelImage(
                resource = asyncPainterResource(data = image),
                contentDescription = null,
                modifier = Modifier.height(150.dp).fillMaxWidth().clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = name,
                    maxLines = 3,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = description,
                    maxLines = 4,
                    style = MaterialTheme.typography.body2,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "USD $price",
                    style = MaterialTheme.typography.button,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "$discount% off",
                    style = MaterialTheme.typography.button,
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

        }
    }
}