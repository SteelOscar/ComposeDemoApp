package com.steeloscar.freetime.compose.ui.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steeloscar.freetime.compose.R
import com.steeloscar.freetime.compose.ui.model.Message
import com.steeloscar.freetime.compose.ui.theme.Shapes

@Composable
fun MessageCard(msg: Message) {

    var isExpanded by rememberSaveable { mutableStateOf(true) }
    Card(
        shape = Shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .animateContentSize()
            .clickable { isExpanded = !isExpanded }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar_mine),
                contentDescription = "description",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(44.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = msg.author,
                    fontSize = 20f.sp,
                    fontWeight = FontWeight.Medium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = msg.message,
                    maxLines = when (isExpanded) {
                        true -> Int.MAX_VALUE
                        false -> 1
                    }
                )
            }
        }
    }
}

@Preview(
    heightDp = 1000,
    widthDp = 400,
    showBackground = true
)
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("author", "msg"))
}