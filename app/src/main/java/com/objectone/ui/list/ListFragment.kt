package com.objectone.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.objectone.R
import com.objectone.toothpick.ListModule
import com.objectone.toothpick.Scopes
import kotlinx.android.synthetic.main.fragment_list.*
import toothpick.Toothpick

class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel

    private var adapter = RecyclerAdapter()

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: delegate this `by lazy` or something
        val listScope = Toothpick.openScopes(Scopes.MAIN, Scopes.LIST)
        listScope.installModules(ListModule(activity!!))
        viewModel = listScope.getInstance(ListViewModel::class.java)

        viewModel.showItems.observe(this, Observer {
            adapter.submitList(it)
        })

        list_rv.layoutManager = LinearLayoutManager(context)
        list_rv.adapter = adapter
    }
}