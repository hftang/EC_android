package com.hftang.latte.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 创建时间：2018/9/3
 * 编写人：hftang
 * 功能描述：代理
 */
public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder unbinder = null;


    public abstract Object setlayout();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;

        if (setlayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setlayout(), container, false);
        } else if (setlayout() instanceof View) {
            rootView = (View) setlayout();
        }

        if (rootView != null) {
            unbinder = ButterKnife.bind(this, rootView);
        }


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
