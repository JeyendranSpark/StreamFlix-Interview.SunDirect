package com.example.streamflix.UI

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streamflix.UI.Adapter.ParentAdapter
import com.example.streamflix.Viewmodel.HomeViewModel
import com.example.streamflix.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val data = viewModel.getHomeContent()
        val adapter = ParentAdapter(data) { videoItem ->
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("VIDEO_DATA", videoItem)
            startActivity(intent)
        }

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter
    }
}
