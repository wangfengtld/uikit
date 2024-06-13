package com.eddie.uikit.dialog

import android.content.Context
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.uikit.databinding.ActivityMainBinding
import com.example.uikit.databinding.DialogBaseTitleBinding

abstract class BaseTitleDialog<B: ViewBinding>(context: Context): BaseBottomDialog<DialogBaseTitleBinding>(context) {

    lateinit var mainBinding: B
    var titleText = ""
    var mCloseListener:(()-> Unit)? = null

    override fun getViewBinding() = DialogBaseTitleBinding.inflate(layoutInflater)

    override fun initView(view: View) {
        mainBinding = getMainViewBinding()
        binding.frameLayout.addView(mainBinding.root)
        binding.title.text = titleText
        binding.tvClose.setOnClickListener {
            dismiss()
            mCloseListener?.invoke()
        }
    }

    abstract fun getMainViewBinding(): B

}