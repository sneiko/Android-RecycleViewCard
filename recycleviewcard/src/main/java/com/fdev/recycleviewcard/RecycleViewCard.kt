package com.fdev.recycleviewcard

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fdev.recycleviewcard.adapter.RecycleViewCardAdapter
import com.fdev.recycleviewcard.enums.RecycleViewCardModelType
import com.fdev.recycleviewcard.enums.RecycleViewCardType
import com.fdev.recycleviewcard.model.RecycleViewCardFieldsModel

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
class RecycleViewCard : RecyclerView {

    /**
     * The text to draw
     */
    private lateinit var mContext: Context
    private var _orientation: RecycleViewCardType = RecycleViewCardType.HORIZONTAL

    var orientation: String = RecycleViewCardType.HORIZONTAL.name
        get() = RecycleViewCardType.valueOf(field).toString()
        set(value) {
            field = RecycleViewCardType.valueOf(value).name
            changeValues()
        }


    constructor(context: Context) : super(context) {
        mContext = context
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        mContext = context
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(attrs, R.styleable.RecycleViewCard, defStyle, 0)
        a.getString(R.styleable.RecyclerView_android_orientation)?.let{
            _orientation = RecycleViewCardType.valueOf(it)
        }

        a.recycle()
    }

    fun setData(fields: RecycleViewCardFieldsModel, data: List<*>, onClick: (id: Int)->Unit) {

        // setup adapter
        val mapData = RecycleViewCardMapper(data)
                .convert(fields)
        val selfAdapter = RecycleViewCardAdapter(mapData, object : RecycleViewCardAdapter.IRecycleViewCardAdapter{
            override fun onItemClick(view: View, id: Int) {
                onClick(id)
            }
        })

        // setup layoutManager
        if(_orientation == RecycleViewCardType.HORIZONTAL) {
            layoutManager = GridLayoutManager(mContext, 1, HORIZONTAL, false)
        } else {
            layoutManager = LinearLayoutManager(mContext)
        }

        adapter = selfAdapter
        changeValues()
    }

    private fun changeValues(){
        requestLayout()
        adapter?.notifyDataSetChanged()

    }
}
