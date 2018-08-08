package com.topzuqiu.module_user.ui.framents;

import com.topzuqiu.lib_common.base.BaseFragment;
import com.topzuqiu.lib_common.di.AppComponent;
import com.topzuqiu.module_user.R;


public class QuestionFragment extends BaseFragment {

    @Override
    protected boolean isSupportDataBinding() {
        return false;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_article;
    }

    @Override
    public void componentInject(AppComponent appComponent) {

    }
}