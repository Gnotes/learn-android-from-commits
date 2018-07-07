package com.example.xing.simplenews.main.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.xing.simplenews.R;
import com.example.xing.simplenews.about.widget.AboutFragment;
import com.example.xing.simplenews.main.presenter.MainPresenter;
import com.example.xing.simplenews.main.presenter.MainPresenterImpl;
import com.example.xing.simplenews.main.view.MainView;
import com.example.xing.simplenews.news.widget.NewsFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    // 抽屉布局
    private DrawerLayout mDrawerLayout;
    // ActionBarDrawerToggle  是 DrawerLayout.DrawerListener实现，暂时理解为是对抽屉展开收缩的监听管理类
    private ActionBarDrawerToggle mDrawerToggle;
    // 工具栏
    private Toolbar mToolbar;
    // 导航视图
    private NavigationView mNavigationView;
    private MainPresenter mMainPresenter;

    /**
     * 视图创建时候的生命周期
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载布局
        setContentView(R.layout.activity_main);
        // 初始化工具栏
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // 设置工具栏，注意方法是set`Support`xxx
        setSupportActionBar(mToolbar);
        // 初始化抽屉布局
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // 初始不知道什么名字的？
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        // 初始导航视图
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
        // 创建P的实例对象，看样子应该是逻辑处理，数据处理的一层，传递this
        // this是当前的mainActivity，activity类继承了Context，
        // 因此很多地方需要传递上下文的函数，直接传递一个activity就可以
        mMainPresenter = new MainPresenterImpl(this);
        // 调用实现的方法加载新闻Fragment
        switch2News();
    }

    /**
     * 是否创建顶部右侧的菜单项的方法
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 通过getMenuInflater去接卸初始化菜单
        // 第一个参数是菜单项布局文件
        // 第二个参数是传递进来的menu对象，应该是加载布局的容器对象，
        // 因为菜单项布局对象中定义的是`菜单项MenuItem`，而Menu中才能有MenuItem吧
        // 返回true表示创建Menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 当菜单项点击时的方法
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化导航视图的监听
     *
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        // 添加选项卡点击监听
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // 执行Fragment碎片替换的方法
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        // 设置选项卡当前点击属性
                        menuItem.setChecked(true);
                        // 关闭抽屉布局
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void switch2News() {
        // 这里就是 AboutFragment 中说的动态加载碎片
        // 先获取FragmentManager
        // 开启事物
        // 替换碎片: 第一个参数是碎片容器，第二个参数是要加载的碎片对象
        // 提交事物
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        mToolbar.setTitle(R.string.navigation_news);
    }

    @Override
    public void switch2Images() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImageFragment()).commit();
//        mToolbar.setTitle(R.string.navigation_images);
    }

    @Override
    public void switch2Weather() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
//        mToolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switch2About() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }
}
