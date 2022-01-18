package com.mrlorx.fixcalc

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.preference.PreferenceFragmentCompat

class ItemSettingsFragment : PreferenceFragmentCompat() {

    private val args: ItemSettingsFragmentArgs by navArgs()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.item_settings, rootKey)
        setHasOptionsMenu(true)

        if (args.itemId > 0)
        // TODO: set item Title as Action Bar Title
        else
            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.string_new)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        if (args.itemId > 0)
            menu.findItem(R.id.settings_menu_done).isVisible = false
        else
            menu.findItem(R.id.settings_menu_delete).isVisible = false
    }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}