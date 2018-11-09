package com.objectone.toothpick

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.objectone.core.list.ListRepository
import com.objectone.ui.list.ListViewModel
import com.objectone.ui.list.ListViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class ListViewModelProvider @Inject constructor(val activity: FragmentActivity) : Provider<ListViewModel> {
    override fun get(): ListViewModel {
        return ViewModelProviders
                .of(activity, ListViewModelFactory(ListRepository()))
                .get(ListViewModel::class.java)
    }
}