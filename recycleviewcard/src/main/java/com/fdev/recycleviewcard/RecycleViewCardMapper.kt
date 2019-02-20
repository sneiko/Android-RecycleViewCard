package com.fdev.recycleviewcard

import com.fdev.recycleviewcard.model.RecycleViewCardFieldsModel
import com.fdev.recycleviewcard.model.RecycleViewCardModel

/*
 * -
 * Project: RecycleViewCardExample
 * Package: com.fdev.recycleviewcard
 * -
 * Author: Neikovich Sergey
 * Email: s_neiko@outlook.com
 * Skype: jastair & Telegram: @sneiko
 * -
 * Date: 20.02.2019
 */
class RecycleViewCardMapper(val data: List<*>) {

    fun convert(model: RecycleViewCardFieldsModel): ArrayList<RecycleViewCardModel> {
        val outData: ArrayList<RecycleViewCardModel> = arrayListOf()
        for (i in 0 until data.count()) {
            outData.add(RecycleViewCardModel(
                    id = readPropery(data[i]!!, model.id)!!,
                    avatar = readPropery(data[i]!!, model.avatar),
                    username = readPropery(data[i]!!, model.username),
                    description = readPropery(data[i]!!, model.description),
                    info = readPropery(data[i]!!, model.info)
            ))
        }
        return outData
    }

    fun <R : Any?> readPropery(instance: Any, propertyName: String?): R? {
        propertyName?.let {
            @Suppress("UNCHECKED_CAST")
            return instance::class.members.first {
                it.name == propertyName
            }.call(instance) as R
        }
        return null
    }
}