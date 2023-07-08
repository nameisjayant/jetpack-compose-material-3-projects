package com.nameisjayant.projects.furniture.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
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
import com.nameisjayant.projects.furniture.data.ShoppingBag
import com.nameisjayant.projects.furniture.data.shoppingList
import com.nameisjayant.projects.ui.theme.DarkOrange
import com.nameisjayant.projects.ui.theme.LightGray_1
import com.nameisjayant.projects.ui.theme.LineColor
import com.nameisjayant.projects.ui.theme.TextColor_1


@Composable
fun CheckOutScreen(
    navHostController: NavHostController
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            IconButton(onClick = {
                navHostController.navigateUp()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            Text(
                text = stringResource(id = R.string.my_shoping_bag), style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier.padding(vertical = 15.dp)
            )

            LazyColumn(
                modifier = Modifier.padding(top = 10.dp, bottom = 80.dp)
            ) {
                items(shoppingList, key = { it.id }) {
                    ShoppingEachRow(data = it)
                }

                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp), color = LineColor,
                        thickness = 5.dp
                    )
                    SpacerHeight()
                    RecommendedProduct()
                }
            }
        }

        CheckoutRow(modifier = Modifier.align(BottomCenter)) {

        }

    }

}

@Composable
fun CheckoutRow(
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
            Column {
                Text(
                    text = "Total", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGray_1
                    )
                )
                Text(
                    text = "$600", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        color = DarkOrange
                    )
                )
            }
            SpacerWidth()
            Button(
                onClick = onClick,
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .weight(0.7f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = TextColor_1,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.proceed_to_checkout),
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
fun ShoppingEachRow(
    data: ShoppingBag
) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = data.icon), contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(80.dp)
                    .align(CenterVertically)
            )
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = data.title, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = TextColor_1
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.White, CircleShape)
                            .border(1.dp, DarkOrange, CircleShape)
                            .size(30.dp),
                        contentAlignment = Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "",
                            Modifier.size(10.dp)
                        )
                    }
                }
                Text(
                    text = "${data.qty} Qty",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = LightGray_1
                    ),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                ) {
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
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

                    Text(
                        text = stringResource(id = R.string._599), style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W600,
                            color = DarkOrange
                        ),
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                }
            }
        }
        SpacerHeight(20.dp)
        Divider(modifier = Modifier.fillMaxWidth(), color = LineColor)

    }

}



