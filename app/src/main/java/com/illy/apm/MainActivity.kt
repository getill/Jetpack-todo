package com.illy.apm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.illy.apm.data.TaskRepository
import com.illy.apm.ui.TaskListScreen
import com.illy.apm.ui.TaskViewModel
import com.illy.apm.ui.theme.APMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val repository = TaskRepository(applicationContext)

        setContent {
            APMTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: TaskViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            @Suppress("UNCHECKED_CAST")
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return TaskViewModel(repository) as T
                            }
                        }
                    )
                    TaskListScreen(viewModel = viewModel)
                }
            }
        }
    }
}
