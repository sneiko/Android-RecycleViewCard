package com.fdev.recycleviewcard.model

import android.graphics.Bitmap

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
data class RecycleViewCardModel(
        var id: Int,
        var avatar: Bitmap?,
        var username: String?,
        var description: String?,
        var info: String?
)