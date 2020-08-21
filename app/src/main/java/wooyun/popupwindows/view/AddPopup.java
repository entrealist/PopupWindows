package wooyun.popupwindows.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import wooyun.popupwindows.R;


public class AddPopup extends PopupWindow {


    public PopupWindow pop;

    public LinearLayout tv_test1, tv_test2;


    public AddPopup(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_dialog_add, null, false);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.getContentView().measure(0, 0);
        pop.setTouchable(true);
        pop.setFocusable(true);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setOutsideTouchable(true);


        tv_test1 = view.findViewById(R.id.ll_test1);
        tv_test2 = view.findViewById(R.id.ll_test2);
    }

    public void show(View v_target) {
        if (pop != null) {
            pop.showAsDropDown(v_target, -((pop.getContentView().getMeasuredWidth() - v_target.getWidth())), 0);
        }
    }


    public void dismiss() {
        if (pop != null) {
            pop.dismiss();
        }
    }
}
