package com.oop.laba2.las

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.tileprovider.tilesource.TileSourcePolicy
import org.osmdroid.tileprovider.tilesource.XYTileSource

object GeobusFactoryMap {
    val GEOBUS_MAP: OnlineTileSourceBase = XYTileSource(
        "Mapnik",
        0, 19, 256, ".png", arrayOf(
            "https://geobus.onld.ru/map/hot/",
        ), "© OpenStreetMap contributors",
        TileSourcePolicy(
            2,
            TileSourcePolicy.FLAG_NO_BULK
                    or TileSourcePolicy.FLAG_NO_PREVENTIVE
                    or TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                    or TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
        )
        // max concurrent thread number is 2 (cf. https://operations.osmfoundation.org/policies/tiles/)
    )
}