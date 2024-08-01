package com.example.word_app_dagger_hilt

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.example.word_app_dagger_hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val viewModel: WordsViewModel by viewModels()
    private lateinit var wordAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingActionButton.setOnClickListener { view ->
            showAddWordDialog()
        }

        setUpRecyclerView()

        viewModel.getAllWords().observe(this){
            wordAdapter.submitList(it)
        }


    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            wordAdapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = wordAdapter
        }
    }


    @SuppressLint("CheckResult")
    private fun showAddWordDialog() {
        MaterialDialog(this).show {
            input { dialog, text ->
                viewModel.saveWord(text.toString()).observe(this@MainActivity){
                        Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_SHORT).show()
                }
            }
            positiveButton(text = "Submit")
        }
    }

}