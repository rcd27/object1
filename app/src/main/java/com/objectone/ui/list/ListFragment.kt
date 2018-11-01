package com.objectone.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.objectone.R
import com.objectone.core.list.ListRepository

class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This is kind of injection. Must be handled in proper way
        viewModel = ViewModelProviders
                .of(activity!!, ListViewModelFactory(ListRepository()))
                .get(ListViewModel::class.java)
        viewModel.showItems.observe(this, Observer {
            // TODO: recycler view accepts List here
        })
    }
}