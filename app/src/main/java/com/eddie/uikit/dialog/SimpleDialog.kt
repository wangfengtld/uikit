package com.eddie.uikit.dialog

import android.content.Context
import com.example.uikit.databinding.DialogSimpleTextBinding

class SimpleDialog(context: Context): BaseTitleDialog<DialogSimpleTextBinding>(context) {
    override fun getMainViewBinding(): DialogSimpleTextBinding {
        return DialogSimpleTextBinding.inflate(layoutInflater)
    }


}