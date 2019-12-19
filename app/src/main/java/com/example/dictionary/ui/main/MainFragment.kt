package com.example.dictionary.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dictionary.R
import com.example.dictionary.ui.main.categories.EnglishUzbekFragment
import com.example.dictionary.ui.main.categories.UzbekEnglishFragment
import com.example.dictionary.util.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var englishUzbekFragment: EnglishUzbekFragment
    private lateinit var uzbekEnglishFragment: UzbekEnglishFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        englishUzbekFragment = EnglishUzbekFragment()
        uzbekEnglishFragment = UzbekEnglishFragment()

        search_tab_layout.setupWithViewPager(search_view_pager)

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(englishUzbekFragment,"Eng - Uzb")
        adapter.addFragment(uzbekEnglishFragment,"O'zb - Ing")

        search_view_pager.adapter = adapter
    }

}
