package com.objectone.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.objectone.core.list.ListRepository
import com.objectone.core.list.data.ObjectOneItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel @Inject constructor(listRepository: ListRepository) : ViewModel() {

    val showItems = MutableLiveData<List<ObjectOneItem>>()
    val showError = MutableLiveData<String>()
    val cd = CompositeDisposable()

    init {
        cd.add(listRepository.getList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> showItems.postValue(result) },
                        { error -> showError.postValue(error.message) }))
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