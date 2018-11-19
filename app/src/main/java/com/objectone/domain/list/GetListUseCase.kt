package com.objectone.domain.list

import com.objectone.core.list.ListRepository
import com.objectone.core.list.data.ObjectOneItem
import io.reactivex.Single
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val listRepository: ListRepository) {

    fun getObjectOneItems(): Single<List<ObjectOneItem>> {
        return listRepository.getList()
                // Some business-logic work here
                .toObservable() // we have dumb business on this project
                .flatMapIterable { list -> list }
                .filter { true }
                .toList()
    }
}