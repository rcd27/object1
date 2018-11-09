package com.objectone.core.list

import com.objectone.core.Result
import com.objectone.core.Success
import com.objectone.core.list.data.ObjectOneItem
import javax.inject.Inject

class ListRepository @Inject constructor() {
    fun getList(): Result<List<ObjectOneItem>> {
        return Success(listOf(
                ObjectOneItem("1", "Title#1", "/fakeImage"),
                ObjectOneItem("2", "Title#2", "/fakeImage"),
                ObjectOneItem("3", "Title#3", "/fakeImage"),
                ObjectOneItem("4", "Title#4", "/fakeImage"),
                ObjectOneItem("1", "Title#5", "/fakeImage")
        ))
    }
}