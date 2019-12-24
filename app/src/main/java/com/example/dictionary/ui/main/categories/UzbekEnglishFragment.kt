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

import com.example.dictionary.R
import com.example.dictionary.adapter.EngUzbAdapter
import com.example.dictionary.adapter.UzbEngAdapter
import com.example.dictionary.db.model.Words
import com.example.dictionary.ui.main.viewmodel.EngUzbViewModel
import com.example.dictionary.ui.main.viewmodel.UzbEngViewModel
import com.example.dictionary.util.toast
import kotlinx.android.synthetic.main.fragment_english_uzbek.*
import kotlinx.android.synthetic.main.fragment_uzbek_english.*

class UzbekEnglishFragment : Fragment(),
UzbEngAdapter.Interaction{

    private lateinit var uzbEngAdapter: UzbEngAdapter
    private lateinit var viewModel: UzbEngViewModel

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
        initVM()
        initRV()
        observe()
    }

    private fun initVM(){
        viewModel = ViewModelProvider(this)[UzbEngViewModel::class.java]
        viewModel.insert(createWordsList())
    }

    private fun initRV() {
        uzb_eng_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            uzbEngAdapter = UzbEngAdapter(this@UzbekEnglishFragment)
            adapter = uzbEngAdapter
        }
    }

    private fun observe() {
        viewModel.allWords.observe(
            this, Observer {
                uzbEngAdapter.submitList(it)
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
        wordsList.add(Words("abadiyat"))
        wordsList.add(Words("abajur"))
        wordsList.add(Words("abbat"))
        wordsList.add(Words("bachkana"))
        wordsList.add(Words("bachki"))
        wordsList.add(Words("bak"))
        wordsList.add(Words("bakalavr"))
        wordsList.add(Words("dabba"))
        wordsList.add(Words("dabdaba"))
        wordsList.add(Words("dada"))
        wordsList.add(Words("dadil"))
        wordsList.add(Words("dadillik"))
        wordsList.add(Words("dafn"))
        wordsList.add(Words("daftar"))
        wordsList.add(Words("daha"))
        wordsList.add(Words("dahliz"))
        return wordsList
    }


}
