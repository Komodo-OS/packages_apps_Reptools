/*
  * SPDX-FileCopyrightText: 2019 The Android Open Source Project
  * SPDX-License-Identifier: Apache-2.0
  */

package org.komodo.settings.category.gestures

import android.content.Context
import android.provider.SearchIndexableResource
import com.android.settings.R
import com.android.settings.dashboard.DashboardFragment
import com.android.settings.search.BaseSearchIndexProvider
import com.android.settingslib.search.SearchIndexable

@SearchIndexable
class SwipeToScreenshotGestureSettings : DashboardFragment() {

    private val TAG = "SwipeToScreenshotGestureSettings"

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun getMetricsCategory(): Int {
        return -1
    }

    override fun getLogTag(): String {
        return TAG
    }

    override fun getPreferenceScreenResId(): Int {
        return R.xml.swipe_to_screenshot_gesture_settings
    }

    companion object {
        @JvmField
        val SEARCH_INDEX_DATA_PROVIDER: BaseSearchIndexProvider = object : BaseSearchIndexProvider() {
            override fun getXmlResourcesToIndex(context: Context, enabled: Boolean): List<SearchIndexableResource> {
                val sir = SearchIndexableResource(context)
                sir.xmlResId = R.xml.swipe_to_screenshot_gesture_settings
                return listOf(sir)
            }
        }
    }
}