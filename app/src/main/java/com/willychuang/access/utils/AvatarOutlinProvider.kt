package com.willychuang.access.utils

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import com.willychuang.access.AccessApplication
import com.willychuang.access.R

class AvatarOutlineProvider : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        view.clipToOutline = true
        val radius = AccessApplication.instance.resources.getDimensionPixelSize(R.dimen.radius_avatar)
        outline.setOval(0, 0, radius, radius)
    }
}