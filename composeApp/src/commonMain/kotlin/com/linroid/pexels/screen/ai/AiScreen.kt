package com.linroid.pexels.screen.ai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.linroid.pexels.screen.feed.FeedModel
import org.jetbrains.compose.ui.tooling.preview.Preview

class AiScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val aiViewModel = rememberScreenModel { AIViewModel() }
        Column {
            TopAppBar(
                title = {
                    Text("AI Samples")
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.pop() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                },
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color.White)
            ) {
                Column {
                    Text("Hello AI Screen")
                    Button(onClick = {
                        aiViewModel.generateResponse("")
                    }, content = {
                        Text("Generate Response")
                    })
                }
            }
        }
    }

}

@Preview
@Composable
fun SimpleComposablePreview() {
    AiScreen()
}