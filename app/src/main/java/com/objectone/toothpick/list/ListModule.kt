package com.objectone.toothpick.list

import androidx.fragment.app.FragmentActivity
import com.objectone.data.list.net.ListApi
import com.objectone.domain.list.GetListUseCase
import com.objectone.ui.list.ListViewModel
import toothpick.config.Module

class ListModule(val activity: FragmentActivity) : Module() {
    init {
        bind(FragmentActivity::class.java).toInstance(activity)
        bind(ListViewModel::class.java).toProvider(ListViewModelProvider::class.java).singletonInScope()
        bind(GetListUseCase::class.java).singletonInScope()
        bind(ListApi::class.java).toProvider(ListApiProvider::class.java).providesSingletonInScope()
    }
}
