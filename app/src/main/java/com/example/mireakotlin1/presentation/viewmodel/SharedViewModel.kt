package com.example.mireakotlin1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mireakotlin1.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<Note>?> = _notes

    init {
        viewModelScope.launch {
            val notes = mutableListOf<Note>()
            for (i in 0..10){
                notes.add(
                    Note(
                        id = i,
                        title = "Note $i",
                        content = "Content $i"
                    )
                )
            }
            _notes.update {
                notes
            }
        }
    }

    fun getNote(id: Int): Note? {
        return _notes.value.find { it.id == id }
    }
}