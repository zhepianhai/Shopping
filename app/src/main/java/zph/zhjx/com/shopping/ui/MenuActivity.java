package zph.zhjx.com.shopping.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import zph.zhjx.com.shopping.R;
import zph.zhjx.com.shopping.adapter.SectionsPagerAdapter;
import zph.zhjx.com.shopping.base.BaseActivity;
import zph.zhjx.com.shopping.find.FindFragment;
import zph.zhjx.com.shopping.home.HomeFragment;
import zph.zhjx.com.shopping.me.MeFragment;
import zph.zhjx.com.shopping.shopcard.ShopCardFragment;
import zph.zhjx.com.shopping.type.TypeFragment;

public class MenuActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setstatusbarcolor("#FFFFFFFF");
        initview();
        setBottomNavigationBar();
        initviewpager();

    }

    private void initviewpager() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new FindFragment());
        fragments.add(new ShopCardFragment());
        fragments.add(new MeFragment());

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }

    /**
     * 设置底部导航
     * */
    private void setBottomNavigationBar() {
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                ).setInActiveColor(R.color.colorhomehui).setBarBackgroundColor("#FFFFFF")
        ;
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(1)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home,R.string.home).setActiveColorResource(R.color.colorhomered))
                .addItem(new BottomNavigationItem(R.mipmap.type,R.string.type).setActiveColorResource(R.color.colorhomered))
                .addItem(new BottomNavigationItem(R.mipmap.find,R.string.find).setActiveColorResource(R.color.colorhomered))
                .addItem(new BottomNavigationItem(R.mipmap.car, R.string.shopcart).setActiveColorResource(R.color.colorhomered).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.mine,R.string.mine).setActiveColorResource(R.color.colorhomered))
                .initialise();
    }
    private void initview() {
        bottomNavigationBar= (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
    }
    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
