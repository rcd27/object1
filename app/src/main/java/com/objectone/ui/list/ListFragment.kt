package com.objectone.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.objectone.R
import com.objectone.core.list.ListRepository
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private var adapter = RecyclerAdapter()

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This is kind of injection. Must be handled in proper way
        viewModel = ViewModelProviders
                .of(activity!!, ListViewModelFactory(ListRepository()))
                .get(ListViewModel::class.java)
        viewModel.showItems.observe(this, Observer {
            adapter.submitList(it)
        })

        list_rv.layoutManager = LinearLayoutManager(context)
        list_rv.adapter = adapter
    }
}