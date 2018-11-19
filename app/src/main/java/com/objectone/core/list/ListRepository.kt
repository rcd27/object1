package com.objectone.core.list

import com.objectone.core.list.data.ObjectOneItem
import com.objectone.data.list.net.ListApi
import io.reactivex.Single
import javax.inject.Inject

class ListRepository @Inject constructor(val api: ListApi) {
    fun getList(): Single<List<ObjectOneItem>> {
        return api.getObjects()
    }
}