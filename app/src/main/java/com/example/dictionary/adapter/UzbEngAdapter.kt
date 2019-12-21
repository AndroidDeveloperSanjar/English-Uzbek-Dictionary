package com.example.dictionary.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.dictionary.R
import com.example.dictionary.models.Word
import kotlinx.android.synthetic.main.uzb_eng_list_item.view.*

class UzbEngAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Word>() {

        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
             return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return UzbEngViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.uzb_eng_list_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UzbEngViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Word>) {
        differ.submitList(list)
    }

    class UzbEngViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Word) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            itemView.tv_uzb_word.text = item.word
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Word)
    }
}
