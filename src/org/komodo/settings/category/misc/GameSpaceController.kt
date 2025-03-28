package org.komodo.settings.category.misc

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.UserHandle
import android.text.TextUtils
import androidx.preference.Preference
import com.android.settings.core.BasePreferenceController

class GameSpaceController(context: Context, preferenceKey: String) : BasePreferenceController(context, preferenceKey) {

    private val mPackageManager: PackageManager = mContext.packageManager

    private fun settingsIntent(): Intent {
        val intent = Intent()
        val component = ComponentName(GAME_PACKAGE, GAME_SETTINGS)
        intent.component = component
        return intent
    }

    override fun getAvailabilityStatus(): Int {
        return if (mContext.packageManager.resolveActivity(settingsIntent(), 0) != null) {
            AVAILABLE
        } else {
            UNSUPPORTED_ON_DEVICE
        }
    }

    override fun handlePreferenceTreeClick(preference: Preference): Boolean {
        if (!TextUtils.equals(preference.key, getPreferenceKey())) {
            return false
        }

        val intent = settingsIntent().apply {
            putExtra("referer", this@GameSpaceController.javaClass.canonicalName)
        }
        mContext.startActivityAsUser(intent, UserHandle.CURRENT)
        return true
    }

    companion object {
        private const val GAME_PACKAGE = "io.chaldeaprjkt.gamespace"
        private const val GAME_SETTINGS = "io.chaldeaprjkt.gamespace.settings.SettingsActivity"
    }
}