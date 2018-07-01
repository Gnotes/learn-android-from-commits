package com.example.xing.simplenews.main.presenter;

import com.example.xing.simplenews.R;
import com.example.xing.simplenews.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    /**
     * 定义mainView的实现实例，用于处理，点击选项卡后的的方法
     */
    private MainView mMainView;

    /**
     * 通过构造传递实例对象，用于初始化
     * @param mMainView
     */
    public MainPresenterImpl(MainView mMainView) {
        this.mMainView = mMainView;
    }

    /**
     * 选项卡点击后的处理方法，跳转到对应的Fragment
     * @param id 当前点击的View ID
     */
    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mMainView.switch2News();
                break;
            case R.id.navigation_item_images:
                mMainView.switch2Images();
                break;
            case R.id.navigation_item_weather:
                mMainView.switch2Weather();
                break;
            case R.id.navigation_item_about:
                mMainView.switch2About();
                break;
            default:
                mMainView.switch2News();
                break;
        }
    }


}
