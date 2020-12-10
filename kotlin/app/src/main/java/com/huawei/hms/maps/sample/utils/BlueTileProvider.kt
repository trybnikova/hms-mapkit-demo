package com.huawei.hms.maps.sample.utils

import android.graphics.Bitmap
import android.graphics.Color
import com.huawei.hms.maps.model.Tile
import com.huawei.hms.maps.model.TileProvider
import java.io.ByteArrayOutputStream

/**
 * Provide blue images as tiles.
 */
class BlueTileProvider : TileProvider {

    override fun getTile(x: Int, y: Int, zoom: Int): Tile? {
        val bitmap = Bitmap.createBitmap(TILE_LENGTH, TILE_LENGTH, Bitmap.Config.RGB_565).apply {
            eraseColor(Color.parseColor("#024CFF"))
        }
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return Tile(TILE_LENGTH, TILE_LENGTH, stream.toByteArray())
    }

    companion object {
        private const val TILE_LENGTH = 512
    }
}
