package com.example.mireakotlin1.domain.repository

import com.example.mireakotlin1.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
}