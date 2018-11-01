package com.objectone.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.objectone.core.data.Error
import com.objectone.core.data.Success
import com.objectone.core.list.ListRepository
import com.objectone.core.list.data.ObjectOneItem

class ListViewModel(listRepository: ListRepository) : ViewModel() {

    // FIXME: not sure this is necessary. Why not just pass `_showItems`?
    private val _showItems = MutableLiveData<List<ObjectOneItem>>()
    val showItems: LiveData<List<ObjectOneItem>>
        get() = _showItems

    init {
        val result = listRepository.getList()
        when (result) {
            is Success -> _showItems.value = result.data
            is Error -> throw IllegalStateException("Error loading list")
        }
    }
}

// TODO: move this ugly motherfucker to `providers` after we have some DI
@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(private val listRepository: ListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != ListViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return ListViewModel(listRepository) as T
    }
}