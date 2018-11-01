package com.objectone.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.objectone.core.data.Result
import com.objectone.core.list.ListRepository
import com.objectone.core.list.data.ObjectOneItem

class ListViewModel(listRepository: ListRepository) : ViewModel() {

    private val _showItems = MutableLiveData<List<ObjectOneItem>>()
    val showItems: LiveData<List<ObjectOneItem>>
        get() = _showItems

    init {
        val result = listRepository.getList()
        when (result) {
            is Result.Success -> _showItems.value = result.data
            is Result.Error -> throw IllegalStateException("Error loading list")
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(private val listRepository: ListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != ListViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return ListViewModel(listRepository) as T
    }
}