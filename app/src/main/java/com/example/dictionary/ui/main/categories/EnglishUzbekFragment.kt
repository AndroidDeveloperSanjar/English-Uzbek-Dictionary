package com.example.dictionary.ui.main.categories


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.dictionary.R
import com.example.dictionary.adapter.EngUzbAdapter
import com.example.dictionary.models.DataSourceForEnglishUzbek
import com.example.dictionary.models.Word
import com.example.dictionary.util.toast
import kotlinx.android.synthetic.main.fragment_english_uzbek.*

/**
 * A simple [Fragment] subclass.
 */
class EnglishUzbekFragment : Fragment(),
EngUzbAdapter.Interaction{

    private lateinit var engUzbAdapter: EngUzbAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_english_uzbek, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRV()
        addDataSet()
    }

    private fun initRV() {
        eng_uzb_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            engUzbAdapter = EngUzbAdapter(this@EnglishUzbekFragment)
            adapter = engUzbAdapter
        }
    }

    private fun addDataSet(){
        val data = DataSourceForEnglishUzbek.createDataSet()
        engUzbAdapter.submitList(data)
    }

    override fun onItemSelected(position: Int, item: Word) {
        toast("postion : #$position")
    }


}
