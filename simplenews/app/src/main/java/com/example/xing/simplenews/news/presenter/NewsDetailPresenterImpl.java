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
    // 详情视图
    private NewsDetailView mNewsDetailView;
    // 新闻请求接口
    private NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context mContent, NewsDetailView mNewsDetailView) {
        this.mContent = mContent;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel = new NewsModelImpl();
    }

    /**
     * 新闻详情请求方法
     * @param docId
     */
    @Override
    public void loadNewsDetail(final String docId) {
        // 显示进度
        mNewsDetailView.showProgress();
        // 初始化请求回调监听
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            // 成功方法
            @Override
            public void onSuccess(String response) {
                // 解析返回数据
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docId);
                if(newsDetailBean != null) {
                    mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
                }
                // 隐藏进度
                mNewsDetailView.hideProgress();
            }

            // 失败方法
            @Override
            public void onFailure(Exception e) {
                mNewsDetailView.hideProgress();
            }
        };
        // 发送请求
        mNewsModel.loadNewsDetail(getDetailUrl(docId), loadNewsCallback);
    }

    /**
     * 组装请求URL
     * @param docId
     * @return
     */
    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }
}
