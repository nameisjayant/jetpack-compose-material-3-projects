package com.nameisjayant.projects.furniture.screens

import android.hardware.lights.Light
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nameisjayant.chatapp.R
import com.nameisjayant.projects.chat.components.SpacerHeight
import com.nameisjayant.projects.chat.components.SpacerWidth
import com.nameisjayant.projects.furniture.data.popularProductList
import com.nameisjayant.projects.furniture.navigation.Checkout
import com.nameisjayant.projects.ui.theme.Background_1
import com.nameisjayant.projects.ui.theme.DarkOrange
import com.nameisjayant.projects.ui.theme.GrayColor
import com.nameisjayant.projects.ui.theme.Gray_1
import com.nameisjayant.projects.ui.theme.LightGray_1
import com.nameisjayant.projects.ui.theme.LightOrange
import com.nameisjayant.projects.ui.theme.LineColor
import com.nameisjayant.projects.ui.theme.TextColor_1


@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    val chips = listOf("Description", "Material", "Review")
    var selected by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.product_four), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillWidth
        )
        HeaderSection {
            navHostController.navigateUp()
        }

        Box(
            modifier = Modifier
                .padding(top = 230.dp)
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(16.dp))

        ) {
            LazyColumn(modifier = Modifier.padding(bottom = 70.dp)) {
                item {
                    ProductHeaderSection()
                    RatingRow()
                    SpacerHeight(10.dp)
                    Row {
                        chips.forEachIndexed { index, s ->
                            CustomChips(
                                title = s,
                                selected = index == selected,
                                index = index,
                                onValueChange = {
                                    selected = it
                                })
                        }
                    }
                    SpacerHeight()
                    Text(
                        text = stringResource(id = R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_etiam_at_mi_vitae_augue_feugiat_scelerisque_in_a_eros),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,
                            color = LightGray_1
                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    SpacerHeight(15.dp)
                    Divider(modifier = Modifier.fillMaxWidth(), color = GrayColor, thickness = 5.dp)
                    RecommendedProduct()
                }
            }
        }

        BottomBarItem(modifier = Modifier.align(BottomCenter)) {
            navHostController.navigate(Checkout)
        }

    }
}

@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(modifier = Modifier.fillMaxWidth(), color = LineColor)
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .size(40.dp),
                border = BorderStroke(1.dp, LightGray_1),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier.size(16.dp),
                    tint = LightGray_1
                )
            }
            SpacerWidth()
            Button(
                onClick = onClick,
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth().weight(0.7f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = TextColor_1,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.add_to_ba),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        }
    }
}

@Composable
fun RecommendedProduct() {

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.recommend_products), style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = TextColor_1
            )
        )
        SpacerHeight(20.dp)
        LazyRow {
            items(popularProductList, key = { it.id }) {
                PopularEachRow(data = it, modifier = Modifier.padding(end = 20.dp)) {
                }
            }

        }
    }

}

@Composable
fun CustomChips(
    title: String,
    selected: Boolean,
    index: Int,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit
) {

    TextButton(
        onClick = { onValueChange(index) },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) LightOrange else Color.Transparent,
            contentColor = if (selected) DarkOrange else LightGray_1
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        modifier = modifier.padding(start = 20.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
            )
        )
    }

}

@Composable
fun RatingRow() {

    val personIcons = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4
    )

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .background(Background_1, RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row {
                    repeat(5) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }
                    SpacerWidth()
                    Text(
                        text = "5.0", style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = TextColor_1
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                SpacerHeight()
                Row() {
                    Text(
                        text = stringResource(id = R.string._98_reviews),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = LightGray_1
                        ),
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                        modifier =
                        Modifier
                            .size(16.dp)
                            .align(CenterVertically),
                        tint = LightGray_1
                    )
                }

            }
            Row {
                personIcons.forEachIndexed { index, i ->
                    Icon(
                        painter = painterResource(id = i), contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(32.dp)
                            .offset(
                                x = if (index == 1) -(10.dp) else if (index == 2) -(20.dp) else if (index == 3) -(30.dp) else 0.dp,
                                y = 0.dp
                            )
                    )
                }
            }
        }
    }

}

@Composable
fun ProductHeaderSection() {

    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.product_name), style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = TextColor_1
            )
        )
        SpacerHeight()
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string._599), style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = DarkOrange
                ),
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
            )
            ProductCountButton {
                if (count > 0)
                    count--
            }
            Text(
                text = "$count", modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(CenterVertically)
            )
            ProductCountButton {
                count++
            }
        }
    }
}

@Composable
fun ProductCountButton(
    onClick: () -> Unit
) {

    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.size(35.dp),
        border = BorderStroke(2.dp, DarkOrange),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = "", tint = DarkOrange)
    }

}

@Composable
fun HeaderSection(
    onBack: () -> Unit
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "", tint = Color.Black)
        }

        Icon(
            painter = painterResource(id = R.drawable.share),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }

}