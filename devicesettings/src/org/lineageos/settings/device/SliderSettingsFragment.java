/*
 * Copyright (C) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MenuItem;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;

import org.lineageos.settings.device.R;
import org.lineageos.settings.utils.FileUtils;

public class SliderSettingsFragment extends PreferenceFragment implements
        OnPreferenceChangeListener {

    private SwitchPreference mSliderPreference;

    private static final String SLIDER_DISABLE_KEY = "slider_disable";
    private static final String SLIDER_DISABLE_PROPERTY = "persist.slider.disable";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.slider_settings);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        mSliderPreference = (SwitchPreference) findPreference(SLIDER_DISABLE_KEY);
        mSliderPreference.setEnabled(true);
        mSliderPreference.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case SLIDER_DISABLE_KEY:
                int slider = SystemProperties.getInt(SLIDER_DISABLE_PROPERTY, 0);
                if (slider == 1) {
                    SystemProperties.set(SLIDER_DISABLE_PROPERTY, "0");
                } else {
                    SystemProperties.set(SLIDER_DISABLE_PROPERTY, "1");
                }
                return true;
            default: return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return false;
    }
}
