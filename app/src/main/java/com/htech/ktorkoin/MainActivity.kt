package com.htech.ktorkoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.htech.ktorkoin.presentation.ui.PostScreen
import com.htech.ktorkoin.presentation.viewModel.PostViewModel
import com.htech.ktorkoin.ui.theme.KtorKoinTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorKoinTheme {
               val vm : PostViewModel = koinViewModel()
                PostScreen(vm)
            }
        }
    }
}