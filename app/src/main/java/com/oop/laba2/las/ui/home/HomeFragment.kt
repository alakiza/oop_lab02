package com.oop.laba2.las.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oop.laba2.las.GeobusFactoryMap
import com.oop.laba2.las.databinding.FragmentHomeBinding
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView

class HomeFragment : Fragment() {

    private lateinit var bind: FragmentHomeBinding
    private lateinit var map: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeBinding.inflate(inflater, container, false)

        map = bind.mainMap
        map.setTileSource(GeobusFactoryMap.GEOBUS_MAP)
        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS)
        map.setMultiTouchControls(true)

        Configuration.getInstance().userAgentValue = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:99.0) Gecko/20100101 Firefox/99.0"

        val mapController = map.controller
        mapController.setZoom(20.0)

        val startPoint = GeoPoint(48.042765 , 37.965335)
        mapController.setCenter(startPoint)

        return bind.root
    }

}