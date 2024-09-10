package com.example.mireakotlin1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mireakotlin1.data.repository.NotesRepositoryImpl
import com.example.mireakotlin1.domain.model.Note
import com.example.mireakotlin1.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {
    private val getNotesUseCase = GetNotesUseCase(NotesRepositoryImpl())
    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<Note>?> = _notes

    init {
        getNotes()
    }

    private fun getNotes(){
        viewModelScope.launch {
            getNotesUseCase.getNotes().collect{ notes ->
                _notes.update {
                    notes
                }
            }
        }
    }

    fun getNote(id: Int): Note? {
        return _notes.value.find { it.id == id }
    }
}