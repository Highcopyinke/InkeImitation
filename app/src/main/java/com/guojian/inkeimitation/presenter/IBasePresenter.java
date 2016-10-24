package com.guojian.inkeimitation.presenter;

/**
 * @author guojian
 * @ Created by guojian on 2016/10/21 0021.
 * @ presenter 基类接口
 */
public interface IBasePresenter {
    /**
     * 运行
     */
    void onResume();

    /**
     * 停止 回收
     */
    void onDestroy();
}
