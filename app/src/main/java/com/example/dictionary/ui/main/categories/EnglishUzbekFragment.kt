package com.example.dictionary.ui.main.categories


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.dictionary.BaseFragment

import com.example.dictionary.R
import com.example.dictionary.adapter.EngUzbAdapter
import com.example.dictionary.db.model.Words
import com.example.dictionary.ui.main.viewmodel.EngUzbViewModel
import kotlinx.android.synthetic.main.fragment_english_uzbek.*
import kotlinx.android.synthetic.main.material_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class EnglishUzbekFragment : BaseFragment(),
EngUzbAdapter.Interaction{

    private lateinit var engUzbAdapter: EngUzbAdapter
    private lateinit var viewModel: EngUzbViewModel

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
        initVM()
        initRV()
        observe()
    }

    private fun initVM(){
        viewModel = ViewModelProvider(this)[EngUzbViewModel::class.java]
        viewModel.insert(createWordsList())
    }

    private fun initRV() {
        eng_uzb_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            engUzbAdapter = EngUzbAdapter(this@EnglishUzbekFragment)
            adapter = engUzbAdapter
        }
    }

    private fun observe() {
        viewModel.allWords.observe(
            this, Observer {
                engUzbAdapter.submitList(it)
            }
        )
    }

    override fun onItemSelected(position: Int, item: Words) {
            showRVItemDialog()
    }

    private fun showRVItemDialog(){
        val dialog = MaterialDialog(context!!)
            .noAutoDismiss()
            .customView(R.layout.material_dialog)
        dialog.show()
    }

    private fun createWordsList(): ArrayList<Words> {
        val wordsList = ArrayList<Words>()
        wordsList.add(Words("aback"))
        wordsList.add(Words("abacus"))
        wordsList.add(Words("abandon"))
        wordsList.add(Words("babe"))
        wordsList.add(Words("baboon"))
        wordsList.add(Words("baby"))
        wordsList.add(Words("bacchanalian"))
        wordsList.add(Words("baccy"))
        wordsList.add(Words("bachelor"))
        wordsList.add(Words("cabaret"))
        wordsList.add(Words("cabbage"))
        wordsList.add(Words("cabbie"))
        wordsList.add(Words("dabble"))
        wordsList.add(Words("dacha"))
        wordsList.add(Words("dad"))
        wordsList.add(Words("daddy"))
        return wordsList
    }
}
