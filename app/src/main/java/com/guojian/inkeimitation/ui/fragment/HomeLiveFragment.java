package com.guojian.inkeimitation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.guojian.inkeimitation.R;
import com.guojian.inkeimitation.presenter.IHomeLivePresenter;
import com.guojian.inkeimitation.presenter.impl.HomeLivePresenterImpl;
import com.guojian.inkeimitation.ui.view.IHomeLiveFragment;
import com.guojian.inkeimitation.utils.ViewTools;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author guojian
 *         Created by guojian on 2016/10/20 0020.
 * @ 首页
 */

public class HomeLiveFragment extends Fragment implements IHomeLiveFragment, View.OnClickListener {

    @BindView(R.id.live_check)
    CheckBox liveCheck;//直播列表
    @BindView(R.id.me_check)
    CheckBox meCheck;//账户
    @BindView(R.id.home_menu_layout)
    LinearLayout homeMenuLayout;//首页按钮布局
    @BindView(R.id.home_premiere)
    ImageButton homePremiere;//开播按钮
    @BindView(R.id.frame_fragment_layout)
    FrameLayout frameFragmentLayout;
    @BindView(R.id.live_layout)
    LinearLayout liveLayout;
    @BindView(R.id.me_layout)
    LinearLayout meLayout;

    private FragmentManager fragmentManager;
    /*
    * 账户页面fragment*/
    private Fragment account = new AccountFragment();
    /*播放列表fragment*/
    private Fragment liveList = new LiveFragment();

    //控制器
    private IHomeLivePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_live, container, false);
        ButterKnife.bind(this, view);
        presenter = new HomeLivePresenterImpl(this);
        initOnClick();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    /**
     * 初始化点击事件
     */
    private void initOnClick() {
        //实现单选
        ViewTools.checkBox(this, liveCheck, meCheck);
        //列表按钮点击
        liveLayout.setOnClickListener(this);
        //账户
        meLayout.setOnClickListener(this);

    }

    /**
     * 显示账户
     */
    public void showAccount() {
        if (fragmentManager == null)
            fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_fragment_layout, account).commit();
    }

    /**
     * 显示播放列表
     */
    public void showLive() {
        if (fragmentManager == null)
            fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_fragment_layout, liveList).commit();
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_layout://账户
                meCheck.callOnClick();
                break;
            case R.id.live_layout://直播列表
                liveCheck.callOnClick();
                break;
            case R.id.live_check://直播列表
                presenter.onLiveClick();
                break;
            case R.id.me_check://账户
                presenter.onMeClick();
                break;
        }
    }
}
