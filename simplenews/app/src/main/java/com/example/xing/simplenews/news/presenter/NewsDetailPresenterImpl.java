package com.example.xing.simplenews.news.presenter;

import android.content.Context;

import com.example.xing.simplenews.beans.NewsDetailBean;
import com.example.xing.simplenews.common.Urls;
import com.example.xing.simplenews.model.NewsModel;
import com.example.xing.simplenews.model.NewsModelImpl;
import com.example.xing.simplenews.news.NewsJsonUtils;
import com.example.xing.simplenews.news.view.NewsDetailView;
import com.example.xing.simplenews.utils.OkHttpUtils;

public class NewsDetailPresenterImpl implements NewsDetailPresenter {
    private Context mContent;
    private NewsDetailView mNewsDetailView;
    private NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context mContent, NewsDetailView mNewsDetailView) {
        this.mContent = mContent;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNewsDetail(final String docId) {
        mNewsDetailView.showProgress();
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docId);
                if(newsDetailBean != null) {
                    mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
                }
                mNewsDetailView.hideProgress();
            }

            @Override
            public void onFailure(Exception e) {
                mNewsDetailView.hideProgress();
            }
        };
        mNewsModel.loadNewsDetail(getDetailUrl(docId), loadNewsCallback);
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }
}
