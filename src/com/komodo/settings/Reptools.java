/*
 * Copyright © 2018 Superior OS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.komodo.settings;

import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.logging.nano.MetricsProto;

public class Reptools extends SettingsPreferenceFragment {

    private static final String GAME_SPACE_CATEGORY = "game_space_category";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.komodo_settings);

        Preference GameSpace = findPreference(GAME_SPACE_CATEGORY);
        if (!getResources().getBoolean(R.bool.has_game_space_available)) {
            getPreferenceScreen().removePreference(GameSpace);
        }

    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.KOMODO;
    }
}
