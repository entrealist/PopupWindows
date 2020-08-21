package wooyun.popupwindows.view

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import wooyun.popupwindows.R

class AddPopup(context: Context?) : PopupWindow() {
    var pop: PopupWindow?
    var tv_test1: LinearLayout
    var tv_test2: LinearLayout
    fun show(v_target: View) {
        if (pop != null) {
            pop!!.showAsDropDown(v_target, -(pop!!.contentView.measuredWidth - v_target.width), 0)
        }
    }

    override fun dismiss() {
        if (pop != null) {
            pop!!.dismiss()
        }
    }

    init {
        val view: View = LayoutInflater.from(context).inflate(R.layout.layout_dialog_add, null, false)
        pop = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        pop!!.contentView.measure(0, 0)
        pop!!.isTouchable = true
        pop!!.isFocusable = true
        pop!!.setBackgroundDrawable(BitmapDrawable())
        pop!!.isOutsideTouchable = true
        tv_test1 = view.findViewById(R.id.ll_test1)
        tv_test2 = view.findViewById(R.id.ll_test2)
    }
}