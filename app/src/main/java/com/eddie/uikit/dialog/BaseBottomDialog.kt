package com.eddie.uikit.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.content.res.AppCompatResources
import androidx.viewbinding.ViewBinding
import com.example.uikit.R

abstract class BaseBottomDialog<B: ViewBinding>(context: Context):Dialog(context) {

    lateinit var binding: B
    abstract fun getViewBinding(): B
    abstract fun initView(view: View)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.setPadding(0, 0, 0, 0)
        window?.decorView?.background = AppCompatResources.getDrawable(context, R.drawable.base_bottom_dialog_cicle_bg)
        window?.setGravity(Gravity.BOTTOM)
        window?.setDimAmount(0.8f)
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
        window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window?.setWindowAnimations(R.style.dialog_base_anim_style)
        binding = getViewBinding()
        val view = binding.root
        setContentView(view)
        setCancelable(true)
        initView(view)
    }

    override fun show() {
        ownerActivity?.let {
            if (it.isDestroyed) {
                return
            }
        }
        super.show()
    }
}