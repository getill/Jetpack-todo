package com.illy.apm.ui

import androidx.lifecycle.ViewModel
import com.illy.apm.data.Task
import com.illy.apm.data.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        _tasks.value = repository.getTasks()
    }

    fun addTask(title: String, description: String) {
        val newTask = Task(title = title, description = description)
        val updatedList = _tasks.value + newTask
        _tasks.value = updatedList
        repository.saveTasks(updatedList)
    }

    fun updateTask(id: String, newTitle: String, newDescription: String) {
        val updatedList = _tasks.value.map {
            if (it.id == id) it.copy(title = newTitle, description = newDescription) else it
        }
        _tasks.value = updatedList
        repository.saveTasks(updatedList)
    }

    fun toggleTaskCompletion(id: String) {
        val updatedList = _tasks.value.map {
            if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it
        }
        _tasks.value = updatedList
        repository.saveTasks(updatedList)
    }

    fun deleteTask(id: String) {
        val updatedList = _tasks.value.filter { it.id != id }
        _tasks.value = updatedList
        repository.saveTasks(updatedList)
    }
}
