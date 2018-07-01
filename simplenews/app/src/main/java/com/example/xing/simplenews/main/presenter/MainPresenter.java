package com.example.xing.simplenews.main.presenter;

/**
 * MVP设计模式的P presenter，还不太清楚
 */
public interface MainPresenter {
    /**
     * 定义选项卡切换时执行的抽象方法
     * @param id 当前点击的View ID
     */
    void switchNavigation(int id);
}
