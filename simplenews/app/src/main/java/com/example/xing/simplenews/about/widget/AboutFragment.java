package com.example.xing.simplenews.about.widget;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xing.simplenews.R;

/**
 * Fragment：翻译过来是碎片的意思，可以简单理解我一个个可以复用的细小模块(将布局View抽象提取成一个碎片，以供其他地方复用)
 * Fragment 加载方式分为两类：
 *  静态加载：在xml中通过<fragment android:name="packageName.className" ...>的方式指定具体要加载的碎片
 *  动态加载：通过代码动态添加到指定的容器中
 *
 * Fragment 在Android SDK 及 support-v4中都存在，support中是对低版本API的兼容，他们使用方式上基本一致，也有少许不同
 *  步骤：
 *  辨析碎片类 AboutFragment 继承 Fragment (继承的包不同)
 *  覆写onCreateView方法
 *
 *  动态方式步骤：
 *  辨析碎片类 AboutFragment 继承 Fragment (继承的包不同)
 *  覆写onCreateView方法
 *  获取FragmentManager
 *  开启事物FragmentTransaction
 *  添加(add)Fragment碎片，也有remove和replace方法
 *  提交事物commit
 */
public class AboutFragment extends Fragment {

    /**
     * LayoutInflater(布局服务)，用于解析(实例化)Layout XML文件(布局XML文件)生成对应的 View对象
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * LayoutInflater.inflate
         * 第一个参数是要解析的xml文件资源id
         * 第二个参数是装载该布局View的父容器，一般传递null就可以了(具体的还不太清楚😅)
         */
        return inflater.inflate(R.layout.fragment_about,null);
    }
}
