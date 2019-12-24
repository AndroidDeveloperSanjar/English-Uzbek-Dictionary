package com.example.dictionary.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.dictionary.R
import com.example.dictionary.db.model.Words
import kotlinx.android.synthetic.main.eng_uzb_list_item.view.*

class EngUzbAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<Words>() {

        override fun areItemsTheSame(oldItem: Words, newItem: Words): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Words, newItem: Words): Boolean {
           return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return EngUzbViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.eng_uzb_list_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EngUzbViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Words>) {
        differ.submitList(list)
    }

    class EngUzbViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Words) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.tv_eng_word.text = item.word
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Words)
    }
}
