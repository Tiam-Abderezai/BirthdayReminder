package com.example.birthdayreminder.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.birthdayreminder.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val TAG = "ListFragment"

    lateinit var _binding: FragmentListBinding
//    private val newsViewModel: NewsViewModel by activityViewModels()
//    private val newsAdapter by lazy { ArticleAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        initUI()
        initAPI()
        return _binding.root
    }

    fun initUI() {
        _binding.apply {
//            toolbarTitle.text =
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = newsAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )

            }
        }

    }

    private fun initAPI() {
        newsViewModel.fetchNews(BuildConfig.API_KEY)
            .observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.SUCCESS -> {
                        Log.i(TAG, "Success: ${it}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        it.data?.let { usersData -> renderList(usersData) }
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.LOADING -> {
                        Log.i(TAG, "Loading: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
//                        binding.recyclerView.visibility = View.INVISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        Log.d(TAG, "Error: ${it.message}")
//                    binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
    }

    private fun renderList(articles: Response<NewsResponse>) {
        newsAdapter.apply {
            Log.d(TAG, "renderList: ${articles.body()?.articles?.size}")
            articles.body()?.articles?.let { addData(it) }
        }
    }
}