package com.example.xing.simplenews.model;

import com.example.xing.simplenews.utils.OkHttpUtils;

public interface NewsModel {
    void loadNews(String url, OkHttpUtils.ResultCallback callback);
    void loadNewsDetail(String url, OkHttpUtils.ResultCallback callback);
}
