package com.example.mireakotlin1.presentation.ui.adapter_delegates

import android.annotation.SuppressLint
import com.example.mireakotlin1.databinding.ItemNoteBinding
import com.example.mireakotlin1.domain.model.Note
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
internal fun noteAdapterDelegate(onClick: (Int) -> Unit) =
    adapterDelegateViewBinding<Note, Note, ItemNoteBinding>({ layoutInflater, parent ->
        ItemNoteBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }) {
        bind {
            with(binding) {
                noteTitleTextView.text = item.title
                noteContentTextView.text = item.content

                root.setOnClickListener{
                    onClick(item.id)
                }
            }
        }
    }