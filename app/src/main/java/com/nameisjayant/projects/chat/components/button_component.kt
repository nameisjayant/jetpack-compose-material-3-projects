package com.nameisjayant.projects.chat.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.chatapp.R


@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.get_started),
    backgroundColor: Color = Color.White,
    foregroundColor: Color = Color.Black,
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(0.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor
    ),
    onClick: () -> Unit
) {

    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(100.dp),
        elevation = elevation,
        colors = colors
    ) {
        Text(
            text = text, style = TextStyle(
                color = foregroundColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }

}