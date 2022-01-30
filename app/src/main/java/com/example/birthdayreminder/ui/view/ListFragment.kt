package com.example.birthdayreminder.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birthdayreminder.R
import com.example.birthdayreminder.data.model.Birthday
import com.example.birthdayreminder.databinding.FragmentListBinding
import com.example.birthdayreminder.ui.adapter.BirthdayAdapter
import java.util.*

class ListFragment : Fragment() {
    private val TAG = "ListFragment"

    lateinit var _binding: FragmentListBinding

    //    private val newsViewModel: NewsViewModel by activityViewModels()
    private var birthdays = mutableListOf<Birthday>()
    private val birthdayAdapter by lazy { BirthdayAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        return _binding.root
    }

    fun initUI() {
        val dummyDate = Date()
        val b1 = Birthday("John", dummyDate, dummyDate, 0)
        val b2 = Birthday("Sarah", dummyDate, dummyDate, 0)
        val b3 = Birthday("Elsa", dummyDate, dummyDate, 0)
        birthdays = mutableListOf(b1,b2,b3)

        birthdayAdapter.apply {
            Log.d(TAG, "renderList: ${birthdays.size}")
            addData(birthdays)
            Log.d(TAG, "renderList: ${birthdays.size}")
//            birthdays?.let { addData(it) }
        }

        _binding.apply {
//            toolbarTitle.text =
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = birthdayAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )
                adapter?.apply {
                    notifyDataSetChanged()
                }
            }
            addNewBirthday.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        }

    }
}