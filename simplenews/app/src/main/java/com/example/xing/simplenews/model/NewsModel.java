package com.example.xing.simplenews.model;

import com.example.xing.simplenews.utils.OkHttpUtils;

/**
 * 加载新闻数据的接口方法
 */
public interface NewsModel {
    void loadNews(String url, OkHttpUtils.ResultCallback callback);
    void loadNewsDetail(String url, OkHttpUtils.ResultCallback callback);
}
