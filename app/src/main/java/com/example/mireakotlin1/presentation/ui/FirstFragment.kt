package com.example.mireakotlin1.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mireakotlin1.R
import com.example.mireakotlin1.databinding.FragmentFirstBinding
import com.example.mireakotlin1.presentation.ui.adapter_delegates.MainAdapter
import com.example.mireakotlin1.presentation.viewmodel.SharedViewModel
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: SharedViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        val adapter = MainAdapter{
            val bundle = Bundle()
            bundle.putInt("id", it)
            findNavController().navigate(R.id.action_to_third_fragment, bundle)
        }
        binding.notesRecyclerView.adapter = adapter
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.notesRecyclerView.layoutManager = layoutManager

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.notes.collect {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        }

        val dividerItemDecoration = DividerItemDecoration(
            binding.notesRecyclerView.context,
            layoutManager.orientation
        )
        binding.notesRecyclerView.addItemDecoration(dividerItemDecoration)


        binding.addNoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_second_fragment)
        }

        return binding.root
    }
}