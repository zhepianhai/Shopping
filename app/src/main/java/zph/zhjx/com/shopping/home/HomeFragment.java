package zph.zhjx.com.shopping.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.List;

import zph.zhjx.com.shopping.R;
import zph.zhjx.com.shopping.home.slide.DepthPageTransformer;
import zph.zhjx.com.shopping.home.slide.NetworkImageHolderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View view;
    List<String> topNewsItems;
    private ConvenientBanner convenientBanner;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);
        initview();
        setSlideShowView111();
        return view;
    }

    private void initview() {
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
    }

    private void setSlideShowView111() {
        topNewsItems.add("http://img06.tooopen.com/images/20160924/tooopen_sy_179893728711.jpg");
        topNewsItems.add("http://img06.tooopen.com/images/20160924/tooopen_sy_179904684231.jpg");
        topNewsItems.add("http://img02.tooopen.com/images/20141231/sy_78327074576.jpg");
        topNewsItems.add("http://img06.tooopen.com/images/20161112/tooopen_sy_185726882764.jpg");
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, topNewsItems) //设置需要切换的View
                .setPointViewVisible(true).setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        })
                //设置翻页的效果，不需要翻页效果可以不设
                .setPageTransformer(new DepthPageTransformer())

                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.bai_dian, R.mipmap.hong_dian})
                //设置指示器位置（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .startTurning(3500)     //设置自动切换（同时设置了切换时间间隔）
                .setManualPageable(true); //设置手动影响（设置了该项无法手动切换）

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
