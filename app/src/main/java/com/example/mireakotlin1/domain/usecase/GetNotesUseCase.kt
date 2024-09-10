package com.example.mireakotlin1.domain.usecase

import com.example.mireakotlin1.domain.repository.NotesRepository

class GetNotesUseCase(
    private val repository: NotesRepository
) {
    fun getNotes() = repository.getNotes()
}