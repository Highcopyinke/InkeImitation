package com.guojian.inkeimitation.utils;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * @author guojian
 * @ Created by guojian on 2016/10/21 0021.
 * @ 视图操作工具
 */
public class ViewTools {

    /**
     * 单选
     */
    public static void checkBox(View.OnClickListener onClickListener, CheckBox... checkBoxs) {
        for (CheckBox checkBox : checkBoxs) {
            checkBox.setOnClickListener(v -> {
                onClickListener.onClick(v);
                for (CheckBox checkBox1 : checkBoxs) {
                    //被点击本身
                    if (v == checkBox1) {
                        //如果是没有选中了就选中
                        if (!checkBox1.isChecked())
                            checkBox1.setChecked(true);
                        continue;
                    }
                    //如果是选中状态才设置不选中
                    if (checkBox1.isChecked())
                        checkBox1.setChecked(false);
                }
            });
        }
    }
}
