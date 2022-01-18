package com.mrlorx.fixcalc

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mrlorx.fixcalc.databinding.FragmentScreenMenuBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ScreenMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScreenMenuFragment : Fragment() {

    private val args: ScreenMenuFragmentArgs by navArgs()

    private enum class EditingState {
        NEW_SCREEN,
        EXISTING_SCREEN
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_screen_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        val editingState =
            if (args.screenId > 0) EditingState.EXISTING_SCREEN
            else EditingState.NEW_SCREEN

        if (editingState == EditingState.NEW_SCREEN)
            menu.findItem(R.id.list_item_start).isVisible = false
        else
            menu.findItem(R.id.list_item_done).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.list_item_settings -> {
                findNavController().navigate(R.id.action_screenMenuFragment_to_screenSettingsFragment)
                true
            }
            R.id.list_item_add -> {
                findNavController().navigate(R.id.action_screenMenuFragment_to_itemSettingsFragment)
                true
            }
            R.id.list_item_start -> {
                // TODO: mit (RecyclerView?) die eigentliche Ansicht implementieren
                true
            }
            R.id.list_item_done -> {
                findNavController().navigate(R.id.action_screenMenuFragment_to_screenSettingsFragment)
                true
            }
            else -> false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentScreenMenuBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (args.screenId > 0)
            // TODO: set current Calc Title as ActionBar Title
        else
            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.string_new)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_menu, container, false)
    }
}