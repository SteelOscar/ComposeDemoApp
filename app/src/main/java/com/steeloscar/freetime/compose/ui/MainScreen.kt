package com.steeloscar.freetime.compose.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steeloscar.freetime.compose.ui.composable.MessageCard
import com.steeloscar.freetime.compose.ui.model.Message
import com.steeloscar.freetime.compose.ui.theme.ComposeDemoAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    showSystemUi = true,
    name = "Light Mode"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true,
    name = "Dark mode"
)
@Composable
internal fun MainScreen() {
    ComposeDemoAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize()) {

            val messages = getMessages()
            var state by rememberSaveable { mutableStateOf(State.LOADING) }

            LaunchedEffect(key1 = 0) {
                launch {
                    delay(2000L)
                    state = State.DATA
                }
            }

            when (state) {

                State.LOADING -> CircularProgressIndicator(
                    modifier = Modifier.wrapContentSize(
                        align = Alignment.Center
                    ),
                    strokeWidth = 2.dp
                )
                State.DATA -> LazyColumn {
                    items(messages) {
                        MessageCard(msg = it)
                    }
                }
            }
        }
    }
}

internal enum class State {

    LOADING,
    DATA
}

private fun getMessages() = listOf(
    Message(
        "Renat",
        "Hi! How's it going?"
    ),
    Message(
        "Colleague",
        "Test...Test...Test..."
    ),
    Message(
        "Colleague",
        "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
    ),
    Message(
        "Colleague",
        "I think Kotlin is my favorite programming language.\n" +
                "It's so much fun!"
    ),
    Message(
        "Colleague",
        "Searching for alternatives to XML layouts..."
    ),
    Message(
        "Colleague",
        "Hey, take a look at Jetpack Compose, it's great!\n" +
                "It's the Android's modern toolkit for building native UI." +
                "It simplifies and accelerates UI development on Android." +
                "Less code, powerful tools, and intuitive Kotlin APIs :)"
    ),
    Message(
        "Colleague",
        "It's available from API 21+ :)"
    ),
    Message(
        "Colleague",
        "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
    ),
    Message(
        "Colleague",
        "Android Studio next version's name is Arctic Fox"
    ),
    Message(
        "Colleague",
        "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
    ),
    Message(
        "Colleague",
        "I didn't know you can now run the emulator directly from Android Studio"
    ),
    Message(
        "Colleague",
        "Compose Previews are great to check quickly how a composable layout looks like"
    ),
    Message(
        "Colleague",
        "Previews are also interactive after enabling the experimental setting"
    ),
    Message(
        "Colleague",
        "Have you tried writing build.gradle with KTS?"
    ),
)