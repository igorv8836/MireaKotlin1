package com.example.mireakotlin1.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mireakotlin1.databinding.FragmentThirdBinding
import com.example.mireakotlin1.presentation.viewmodel.SharedViewModel

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        arguments?.let {
            val note = viewModel.getNote(it.getInt("id"))
            binding.noteTitleTextView.text = note?.title
            binding.noteDescriptionTextView.text = note?.content
        }

        return binding.root
    }
}