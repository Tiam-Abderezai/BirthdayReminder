package com.example.birthdayreminder.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birthdayreminder.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var _binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        initUI()
//        initAPI()
        return _binding.root
    }

    fun initUI() {
        _binding.apply {
//            toolbarTitle.text =
//            recyclerView.apply {
//                layoutManager = LinearLayoutManager(requireContext())
//                adapter = newsAdapter
//                addItemDecoration(
//                    DividerItemDecoration(
//                        context,
//                        (layoutManager as LinearLayoutManager).orientation
//                    )
//                )

            }
        }
}