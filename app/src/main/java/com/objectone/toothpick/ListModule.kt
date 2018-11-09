package com.objectone.toothpick

import androidx.fragment.app.FragmentActivity
import com.objectone.core.list.ListRepository
import com.objectone.ui.list.ListViewModel
import toothpick.config.Module

class ListModule(val activity: FragmentActivity) : Module() {
    init {
        bind(FragmentActivity::class.java).toInstance(activity)
        bind(ListViewModel::class.java).toProvider(ListViewModelProvider::class.java).singletonInScope()
    }
}
