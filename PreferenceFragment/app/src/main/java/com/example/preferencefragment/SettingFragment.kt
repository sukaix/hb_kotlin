package com.example.preferencefragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?){
        addPreferencesFromResource(R.xml.preference)
    }
}