package com.objectone.core.list

import com.objectone.core.data.Result
import com.objectone.core.data.Success
import com.objectone.core.list.data.ObjectOneItem

class ListRepository {
    fun getList(): Result<List<ObjectOneItem>> {
        return Success(emptyList())
    }
}