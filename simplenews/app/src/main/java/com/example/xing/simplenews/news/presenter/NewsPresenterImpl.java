package com.example.xing.simplenews.news.presenter;

import android.content.Context;

import com.example.xing.simplenews.beans.NewsBean;
import com.example.xing.simplenews.common.Urls;
import com.example.xing.simplenews.model.NewsModel;
import com.example.xing.simplenews.model.NewsModelImpl;
import com.example.xing.simplenews.news.view.NewsView;
import com.example.xing.simplenews.news.widget.NewsFragment;
import com.example.xing.simplenews.utils.Logs;
import com.example.xing.simplenews.news.NewsJsonUtils;
import com.example.xing.simplenews.utils.OkHttpUtils;

import java.util.List;

public class NewsPresenterImpl implements NewsPresenter {

    private static final String TAG = "NewsPresenterImpl";

    private Context mContext;
    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenterImpl(Context context, NewsView newsView) {
        this.mContext = context;
        this.mNewsView = newsView;
        this.mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNews(final int type, final int pageIndex) {
        String url = getUrl(type, pageIndex);
        Logs.d(TAG, url);
        //只有第一页的或者刷新的时候才显示刷新进度条
        if(pageIndex == 0) {
            mNewsView.showProgress();
        }
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                mNewsView.hideProgress();
                if(pageIndex == 0) {
                    mNewsView.showNews(newsBeanList);
                } else {
                    mNewsView.addNews(newsBeanList);
                }
            }

            @Override
            public void onFailure(Exception e) {
                mNewsView.hideProgress();
                mNewsView.showLoadFailMsg();
            }
        };
        mNewsModel.loadNews(url, loadNewsCallback);
    }

    /**
     * 根据类别和页面索引创建url
     * @param type
     * @param pageIndex
     * @return
     */
    private String getUrl(int type, int pageIndex) {
        StringBuffer sb = new StringBuffer();
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                sb.append(Urls.COMMON_URL).append(Urls.NBA_ID);
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                sb.append(Urls.COMMON_URL).append(Urls.CAR_ID);
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                sb.append(Urls.COMMON_URL).append(Urls.JOKE_ID);
                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
        }
        sb.append("/").append(pageIndex).append(Urls.END_URL);
        return sb.toString();
    }

    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                id = Urls.NBA_ID;
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                id = Urls.CAR_ID;
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                id = Urls.JOKE_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }
        return id;
    }

}