package com.topzuqiu.module_user.ui.framents;

import com.topzuqiu.lib_common.base.BaseFragment;
import com.topzuqiu.module_user.R;
import com.topzuqiu.module_user.databinding.FragmentArticleBinding;


public class QuestionFragment extends BaseFragment {

    @Override
    protected boolean isSupportDataBinding() {
        return false;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_article;
    }
}