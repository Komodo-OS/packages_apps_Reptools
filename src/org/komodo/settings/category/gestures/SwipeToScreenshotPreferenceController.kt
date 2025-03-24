/*
  * SPDX-FileCopyrightText: 2019 The Android Open Source Project
  * SPDX-License-Identifier: Apache-2.0
  */

package org.komodo.settings.category.gestures

import android.provider.Settings.System.THREE_FINGER_GESTURE

import android.content.Context
import android.provider.Settings
import android.text.TextUtils
import com.android.settings.gestures.GesturePreferenceController

class SwipeToScreenshotPreferenceController(context: Context, key: String) : GesturePreferenceController(context, key) {

    private val ON = 1
    private val OFF = 0

    companion object {
        private const val PREF_KEY_VIDEO = "swipe_to_screenshot_video"
    }

    override fun getAvailabilityStatus(): Int {
        return AVAILABLE
    }

    override fun isSliceable(): Boolean {
        return TextUtils.equals(preferenceKey, "swipe_to_screenshot")
    }

    override fun getVideoPrefKey(): String {
        return PREF_KEY_VIDEO
    }

    override fun setChecked(isChecked: Boolean): Boolean {
        return Settings.System.putInt(mContext.contentResolver, THREE_FINGER_GESTURE, if (isChecked) ON else OFF)
    }

    override fun isChecked(): Boolean {
        return Settings.System.getInt(mContext.contentResolver, THREE_FINGER_GESTURE, 0) != 0
    }
}