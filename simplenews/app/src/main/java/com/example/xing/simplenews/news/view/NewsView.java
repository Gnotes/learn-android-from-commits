package com.example.xing.simplenews.news.view;

import com.example.xing.simplenews.beans.NewsBean;

import java.util.List;

public interface NewsView {
    void showProgress();

    void hideProgress();

    void showNewsList(List list);

    void showNews(List<NewsBean> newsList);

    void addNews(List<NewsBean> newsList);

    void showLoadFailMsg();

}
