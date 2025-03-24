package org.komodo.settings

import com.android.internal.logging.nano.MetricsProto
import com.android.settings.dashboard.DashboardFragment
import com.android.settings.R
import com.android.settings.search.BaseSearchIndexProvider
import com.android.settingslib.search.SearchIndexable

@SearchIndexable
class Reptools : DashboardFragment() {

    override fun getPreferenceScreenResId(): Int {
        return R.xml.reptools_dashboard
    }

    override fun getMetricsCategory(): Int {
        return MetricsProto.MetricsEvent.KOMODO
    }

    override fun getLogTag(): String {
        return TAG
    }

    companion object {
        const val CATEGORY_KEY = "com.android.settings.category.ia.reptools"
        private const val TAG = "Reptools"

        @JvmField
        val SEARCH_INDEX_DATA_PROVIDER = BaseSearchIndexProvider(R.xml.reptools_dashboard)
    }
}
