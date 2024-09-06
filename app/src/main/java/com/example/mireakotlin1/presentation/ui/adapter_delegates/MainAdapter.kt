package com.example.mireakotlin1.presentation.ui.adapter_delegates

import com.example.mireakotlin1.domain.model.Note
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

internal class MainAdapter(val onClick: (Int) -> Unit) : ListDelegationAdapter<List<Note>>() {
    init {
        delegatesManager.addDelegate(noteAdapterDelegate(onClick))
    }
}