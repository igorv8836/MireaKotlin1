package com.example.mireakotlin1.data.repository

import com.example.mireakotlin1.domain.model.Note
import com.example.mireakotlin1.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImpl: NotesRepository {
    override fun getNotes(): Flow<List<Note>> {
        return flow {
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
            emit(notes)
        }
    }
}