package com.example.rpwg.Kihya.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myapplication0808.ui.component.discountPercentPriceTextStyle
import com.example.myapplication0808.ui.component.discountPriceTextStyle
import com.example.myapplication0808.ui.component.originalPriceTextStyle
import com.example.myapplication0808.ui.component.productDescriptionStyle
import com.example.myapplication0808.ui.component.titleTextStyle
import com.example.rpwg.R


data class ProductEntity(val title: String, val price: Int) {
    companion object {
        fun getDummy(title: String) : ProductEntity {
            return ProductEntity(title, 100)
        }
    }
}

@Composable
fun ProductsMain(titleInput: String,
                 descriptionInput: String) {

    val productList = remember { mutableStateOf<List<ProductEntity>>((0..100).map {  ProductEntity.getDummy("product: $it") }) }

    ProductBackground() {
        Title(titleInput = titleInput,
            descriptionInput = descriptionInput
        )
        ProductList() {
            productList.value.forEach { aProduct ->
                ProductPreview() {
                    ProductImage()
                    ProductTitle("[세금포함]적토마(세키토바) ${aProduct.title}")
                    ProductOriginalPrice(aProduct.price.toLong(), modifier = Modifier)
                }
                ProductPreview() {
                    ProductImage()
                    ProductTitle("물건 2")
                    DisCountProductPrices(productDiscountPrice = 29000, percent = 35, productOriginalPrice = 18900)
                }
            }
        }
    }
}

@Composable
fun ProductBackground(components: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.White)
            .padding(10.dp)
    ) {
        components()
    }
}

@Composable
fun ProductList(productPreview: @Composable () -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        productPreview()
    }
}


@Composable
fun Title(titleInput: String, descriptionInput: String
) {
    Column(verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text(titleInput, style = titleTextStyle, overflow = TextOverflow.Ellipsis, maxLines = 1,
            modifier = Modifier

        )
        Text(descriptionInput, overflow = TextOverflow.Ellipsis, maxLines = 1,)
    }
}

@Composable
fun ProductPreview(productContent: @Composable () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
    ) {
        productContent()
    }
}

@Composable
fun ProductImage(image: Int = R.drawable.myimage, imageDescription: String = "") {
    Image(painter = painterResource(image),
        contentDescription = imageDescription,
        modifier = Modifier.size(150.dp)
    )
}
//@Preview(showBackground = true)
@Composable
fun ProductTitle(titleText: String, modifier: Modifier = Modifier) {
    Text(titleText, overflow = TextOverflow.Ellipsis, maxLines = 1, style = productDescriptionStyle,
        modifier = modifier
    )
}

@Composable
fun DisCountProductPrices(productOriginalPrice: Long, productDiscountPrice: Long, percent: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ProductDiscountPrice(productDiscountPrice)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ProductDiscountPercent(percent)
            ProductOriginalPrice(productOriginalPrice)
        }
    }
}

@Composable
fun ProductOriginalPrice(productOriginalPrice: Long, modifier: Modifier = Modifier
) {
    Text("${productOriginalPrice}원", overflow = TextOverflow.Ellipsis, maxLines = 1, style = originalPriceTextStyle,
        modifier = modifier
    )
}

@Composable
fun ProductDiscountPrice(productDiscountPrice: Long, modifier: Modifier = Modifier) {
    Text("${productDiscountPrice}원", overflow = TextOverflow.Ellipsis, maxLines = 1, style = discountPriceTextStyle, textDecoration = TextDecoration.LineThrough,
        modifier = modifier
    )
}

@Composable
fun ProductDiscountPercent(percent: Int = 0) {
    Text("${percent}%", style = discountPercentPriceTextStyle)
}