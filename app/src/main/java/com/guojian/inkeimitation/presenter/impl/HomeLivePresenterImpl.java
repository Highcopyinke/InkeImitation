package com.guojian.inkeimitation.presenter.impl;

import com.guojian.inkeimitation.presenter.IHomeLivePresenter;
import com.guojian.inkeimitation.ui.view.IHomeLiveFragment;

/**
 * @author guojian
 * @ Created by guojian on 2016/10/21 0021.
 * @ 首页控制器
 */
public class HomeLivePresenterImpl implements IHomeLivePresenter {
    //视图交互接口
    private IHomeLiveFragment view;

    public HomeLivePresenterImpl(IHomeLiveFragment iHomeLiveFragment) {
        view = iHomeLiveFragment;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
