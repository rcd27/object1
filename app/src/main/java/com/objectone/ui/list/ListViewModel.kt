package com.objectone.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.objectone.core.list.data.ObjectOneItem
import com.objectone.domain.list.GetListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel @Inject constructor(getListUseCase: GetListUseCase) : ViewModel() {

    val showItems = MutableLiveData<List<ObjectOneItem>>()
    val showError = MutableLiveData<String>()
    val cd = CompositeDisposable()

    init {
        cd.add(getListUseCase.getObjectOneItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> showItems.postValue(result) },
                        { error -> showError.postValue(error.message) }))
    }
}