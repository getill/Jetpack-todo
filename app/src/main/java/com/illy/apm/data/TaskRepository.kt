package com.illy.apm.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskRepository(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("tasks_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    private val TASKS_KEY = "TASKS_LIST"

    fun getTasks(): List<Task> {
        val json = prefs.getString(TASKS_KEY, null)
        return if (json == null) {
            emptyList()
        } else {
            val type = object : TypeToken<List<Task>>() {}.type
            gson.fromJson(json, type)
        }
    }

    fun saveTasks(tasks: List<Task>) {
        val json = gson.toJson(tasks)
        prefs.edit().putString(TASKS_KEY, json).apply()
    }
}
