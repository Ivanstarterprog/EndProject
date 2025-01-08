package com.example.endproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endproject.Film
import com.example.endproject.FilmAdapter
import com.example.endproject.FilmsList
import com.example.endproject.R
import com.example.endproject.RetrofitClient
import com.example.endproject.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: FilmAdapter
    private lateinit var viewModel: HomeViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.items.observe(viewLifecycleOwner){ films ->
            Log.i("Adapter", films.toString())
            adapter = FilmAdapter(films) { selectedFilm ->
                navigateToFilm(selectedFilm)
            }
            binding.recyclerView.adapter = adapter
        }
        viewModel.fetchFilms()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToFilm(item: Film) {
        TODO()
    }
}