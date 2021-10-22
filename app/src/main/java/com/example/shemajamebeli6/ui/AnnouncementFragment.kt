package com.example.shemajamebeli6.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli6.R
import com.example.shemajamebeli6.databinding.AnnouncementFragmentBinding

class AnnouncementFragment : BaseFragment<AnnouncementFragmentBinding>(AnnouncementFragmentBinding::inflate) {


    private val viewModel by viewModels<AnnouncementViewModel>()
    private val adapter : AnnouncementAdapter = AnnouncementAdapter()
    override fun init() {
        setRecycler()
        setObservers()
    }


    private fun setRecycler(){
        binding.recyclerView.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    private fun setObservers(){
        viewModel.data.observe(viewLifecycleOwner){ data->
            adapter.data = data.body()?.content!!
        }
    }
}