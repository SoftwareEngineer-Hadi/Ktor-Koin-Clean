package com.htech.ktorkoin.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.htech.ktorkoin.presentation.post.PostUiState
import com.htech.ktorkoin.presentation.viewModel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.loadPosts() }
        ) {
            Text("Load Posts")
        }

        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        BasicTextField(
            value = body,
            onValueChange = { body = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.addPost(1, title, body) }
        ) {
            Text("Create Post")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (state) {
            is PostUiState.Idle -> Text("Idle")
            is PostUiState.Loading -> CircularProgressIndicator()
            is PostUiState.Error -> Text("Error: ${(state as PostUiState.Error).message}")
            is PostUiState.ListData -> {
                val posts = (state as PostUiState.ListData).posts
                Text("Loaded ${posts.size} posts. First: ${posts.firstOrNull()?.title ?: ""}")
            }
            is PostUiState.Created -> {
                val post = (state as PostUiState.Created).post
                Text("Created Post ID = ${post.id}, Title = ${post.title}")
            }
        }
    }
}