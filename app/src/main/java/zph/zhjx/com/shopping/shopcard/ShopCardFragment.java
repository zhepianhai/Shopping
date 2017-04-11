package zph.zhjx.com.shopping.shopcard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zph.zhjx.com.shopping.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCardFragment extends Fragment {


    public ShopCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_card, container, false);
    }

}
