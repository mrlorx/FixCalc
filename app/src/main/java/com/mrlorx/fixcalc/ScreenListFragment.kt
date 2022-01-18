package com.mrlorx.fixcalc

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mrlorx.fixcalc.databinding.FragmentScreenListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ScreenListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScreenListFragment : Fragment() {

    private val data = arrayOf("helo", "diese")

    private val adapter = ScreenListAdapter(data)

    private var isEditingList = false


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_edit -> {
                updateOptionsMenu()
                true
            }
            R.id.main_settings -> {
                findNavController().navigate(R.id.action_fragmentScreenList_to_generalSettingsFragment)
                isEditingList = false
                true
            }
            R.id.main_about -> {
                true
            }
            R.id.list_screen_done -> {
                updateOptionsMenu()
                true
            }
            R.id.list_screen_add -> {
                findNavController().navigate(
                    ScreenListFragmentDirections.actionFragmentScreenListToScreenMenuFragment()
                )
                isEditingList = false
                true
            }
            else -> false
        }
    }

    private fun updateOptionsMenu() {
        isEditingList = !isEditingList
        requireActivity().invalidateOptionsMenu()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

        val binding = FragmentScreenListBinding.bind(view)

        binding.screenRecyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (isEditingList)
            inflater.inflate(R.menu.edit_list_menu, menu)
        else
            inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentScreenListBinding.inflate(inflater, container, false).root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

}