package com.objectone.toothpick.list

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.objectone.core.list.ListRepository
import com.objectone.data.list.net.ListApi
import com.objectone.domain.list.GetListUseCase
import com.objectone.ui.list.ListViewModel
import javax.inject.Inject
import javax.inject.Provider

class ListViewModelProvider
@Inject constructor(val activity: FragmentActivity,
                    private val listApi: ListApi) : Provider<ListViewModel> {

    override fun get(): ListViewModel {
        return ViewModelProviders
                .of(activity, ListViewModelFactory(GetListUseCase(ListRepository(listApi))))
                .get(ListViewModel::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    class ListViewModelFactory(private val getListUseCase: GetListUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass != ListViewModel::class.java) {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
            return ListViewModel(getListUseCase) as T
        }
    }
}