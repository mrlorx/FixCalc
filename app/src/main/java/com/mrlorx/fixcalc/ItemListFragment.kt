package com.mrlorx.fixcalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrlorx.fixcalc.databinding.FragmentItemListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ItemListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemListFragment : Fragment() {

    private val data = arrayOf("Glühwein", "Püfferkes")

    private val adapter = ItemListAdapter(data)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentItemListBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        binding.itemRecyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }
}