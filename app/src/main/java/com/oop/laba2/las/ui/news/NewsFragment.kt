package com.oop.laba2.las.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.oop.laba2.las.MainActivity
import com.oop.laba2.las.R
import com.oop.laba2.las.databinding.NewsFragmentBinding
import com.oop.laba2.las.databinding.FragmentNewsItemBinding
import java.util.*


class NewsFragment : Fragment() {
    private lateinit var binding: NewsFragmentBinding

//    var widthDp : Int = 0
    var width : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)

        Log.d("TEST", "onCreateView")


//        val density = context?.resources?.displayMetrics?.density
//        if (density != null) {
////            widthDp = ((this.activity as MainActivity).width / density).toInt()
//            width = (this.activity as MainActivity).width
//        }

//        Log.d("TEST", context?.resources?.displayMetrics?.density.toString())
//        Log.d("TEST", (this.activity as MainActivity).width.toString())
//        Log.d("TEST", (this.activity as MainActivity).height.toString())
//        Log.d("TEST", (this.activity as MainActivity).density.toString())
//        Log.d("TEST", widthDp.toString())

        width = (this.activity as MainActivity).width

        val sub_headers = resources.getStringArray(R.array.card_header)
        val headers = resources.getStringArray(R.array.card_sub_header)

        var i = 0
        while (i < headers.size) {
            val fragment_binding = FragmentNewsItemBinding.inflate(inflater)
            fragment_binding.root.id = View.generateViewId()
            fragment_binding.cardHeader.text    = headers[i]
            fragment_binding.cardSubHeader.text = sub_headers[i]

            val fragWidth : Int = (width / 2.3).toInt()
            val fragHeight : Int = fragWidth * 3 / 2

            fragment_binding.root.layoutParams = FrameLayout.LayoutParams(fragWidth, fragHeight)
            binding.newsContentMain.addView(fragment_binding.root)
            binding.newsContentFlow.addView(fragment_binding.root)
            ++i
        }

        return binding.root
    }

}