package com.example.dictionary.ui.main.categories


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.dictionary.R
import com.example.dictionary.adapter.UzbEngAdapter
import com.example.dictionary.db.model.Words
import com.example.dictionary.util.toast
import kotlinx.android.synthetic.main.fragment_uzbek_english.*

class UzbekEnglishFragment : Fragment(),
UzbEngAdapter.Interaction{

    private lateinit var uzbEngAdapter: UzbEngAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uzbek_english, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRv()
       // addDataSet()
    }

    private fun initRv() {
        uzb_eng_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            uzbEngAdapter = UzbEngAdapter(this@UzbekEnglishFragment)
            adapter = uzbEngAdapter
        }
    }

//    private fun addDataSet() {
//        val data = DataSourceForUzbekEnglish.createDataSet()
//        uzbEngAdapter.submitList(data)
//    }

    override fun onItemSelected(position: Int, item: Words) {
        toast("position : #$position")
    }


}
