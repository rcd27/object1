package com.objectone.ui.list

import androidx.lifecycle.ViewModel
import com.objectone.core.list.ListRepository

class ListViewModel(listRepository: ListRepository) : ViewModel() {

    init {
        val result = listRepository.getList()
        // Here can be implemented Result<T> logic. Or even Result<Some,None> for example.
    }
}