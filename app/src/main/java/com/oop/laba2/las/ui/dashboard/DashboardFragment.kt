package com.oop.laba2.las.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oop.laba2.las.R
import com.oop.laba2.las.databinding.FragmentDashboardBinding
import com.oop.laba2.las.databinding.DashboardItemBinding
import com.oop.laba2.las.databinding.DashboardImageItemBinding
import java.util.*

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val items_list = LinkedList<DashboardItemBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        items_list.clear()

        for (i in 0..10) {
            val frag_binding = DashboardItemBinding.inflate(inflater)
            val card_layout_params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,500)
            card_layout_params.setMargins(0, 32, 0, 0)
            frag_binding.root.layoutParams = card_layout_params
            frag_binding.textViewHeader.text = "TEST TESTTEST TESTTESTTEST"
            frag_binding.root.id = ConstraintLayout.generateViewId()
            frag_binding.constraintLayoutContent.id = ConstraintLayout.generateViewId()
            Log.d("TEST", "Container ${frag_binding.constraintLayoutContent.id}")

            val images_list = LinkedList<DashboardImageItemBinding>()

            for (j in 0..2) {
                Log.d("TEST", j.toString())
                val frag_image_binding = DashboardImageItemBinding.inflate(inflater)
                frag_image_binding.root.layoutParams = ConstraintLayout.LayoutParams(200, 200)
                frag_image_binding.root.id = ConstraintLayout.generateViewId()

                frag_binding.constraintLayoutContent.addView(frag_image_binding.root)

                val set = ConstraintSet()
                set.clone(frag_binding.constraintLayoutContent)
//                set.constrainHeight(frag_image_binding.root.id, 300);
//                set.constrainWidth(frag_image_binding.root.id, 300);

                if (j == 0) {
                    Log.d("TEST", "ME ${frag_image_binding.root.id}")
                    set.connect(
                        frag_image_binding.root.id, ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 32
                    )
                } else {
                    Log.d("TEST", "ME ${frag_image_binding.root.id}")
                    Log.d("TEST", "NEIGHBOUR ${images_list.last.root.id}")
                    set.connect(
                        frag_image_binding.root.id, ConstraintSet.START,
                        images_list.last.root.id, ConstraintSet.END, 32
                    )
                }

                set.connect(
                    frag_image_binding.root.id, ConstraintSet.TOP,
                    ConstraintSet.PARENT_ID, ConstraintSet.TOP, 32
                )

                set.connect(
                    frag_image_binding.root.id, ConstraintSet.BOTTOM,
                    ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 32
                )

                set.applyTo(frag_binding.constraintLayoutContent)

                images_list.add(frag_image_binding)
            }

            items_list.add(frag_binding)
            binding.dashboardLinearContentMain.addView(frag_binding.root)
        }

        return binding.root
    }

}