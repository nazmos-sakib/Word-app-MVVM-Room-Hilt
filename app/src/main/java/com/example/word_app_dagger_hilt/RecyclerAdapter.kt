package com.example.word_app_dagger_hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.word_app_dagger_hilt.databinding.RecCardItemBinding
import com.example.word_app_dagger_hilt.model.Word


class RecyclerAdapter : ListAdapter<Word,RecyclerAdapter.ViewHolder>(WordDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
         RecCardItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class WordDC:DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem==newItem
        }
    }


    //inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    inner class ViewHolder(private val binding:RecCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Word){
            binding.word = item
        }
    }

    interface Interaction{

    }
}