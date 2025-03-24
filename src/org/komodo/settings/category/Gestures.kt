/*
  * SPDX-FileCopyrightText: 2019 The Android Open Source Project
  * SPDX-License-Identifier: Apache-2.0
  */

package org.komodo.settings.category

import android.content.Context
import android.provider.SearchIndexableResource
import com.android.internal.logging.nano.MetricsProto
import com.android.settings.R
import com.android.settings.dashboard.DashboardFragment
import com.android.settings.search.BaseSearchIndexProvider
import com.android.settingslib.search.SearchIndexable

@SearchIndexable
class Gestures : DashboardFragment() {

    private val TAG = "Komodo Gestures"

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun getMetricsCategory(): Int {
        return MetricsProto.MetricsEvent.KOMODO
    }

    override fun getLogTag(): String {
        return TAG
    }

    override fun getPreferenceScreenResId(): Int {
        return R.xml.komodo_gestures
    }

    companion object {
        @JvmField
        val SEARCH_INDEX_DATA_PROVIDER: BaseSearchIndexProvider = object : BaseSearchIndexProvider() {
            override fun getXmlResourcesToIndex(context: Context, enabled: Boolean): List<SearchIndexableResource> {
                val sir = SearchIndexableResource(context)
                sir.xmlResId = R.xml.komodo_gestures
                return listOf(sir)
            }
        }
    }
}