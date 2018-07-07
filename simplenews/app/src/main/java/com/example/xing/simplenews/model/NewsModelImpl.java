package com.example.xing.simplenews.model;

import com.example.xing.simplenews.utils.OkHttpUtils;

public class NewsModelImpl implements NewsModel {
    @Override
    public void loadNews(String url, OkHttpUtils.ResultCallback callback) {
        OkHttpUtils.get(url,callback);
    }

    @Override
    public void loadNewsDetail(String url, OkHttpUtils.ResultCallback callback) {
        OkHttpUtils.get(url, callback);
    }
}
