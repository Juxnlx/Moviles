package com.example.loteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.loteria.ui.navigation.LoteriaNavGraph
import com.example.loteria.ui.viewmodel.LoteriaViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = remember { LoteriaViewModel() }
            LoteriaNavGraph(viewModel)
        }
    }
}
