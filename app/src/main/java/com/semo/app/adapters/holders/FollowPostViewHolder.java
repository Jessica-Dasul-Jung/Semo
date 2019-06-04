package com.semo.app.adapters.holders;

import android.view.View;

import com.semo.app.main.base.BaseActivity;
import com.semo.app.managers.listeners.OnPostChangedListener;
import com.semo.app.model.FollowingPost;
import com.semo.app.model.Post;
import com.semo.app.utils.LogUtil;

/**
 * Created by Alexey on 22.05.18.
 */
public class FollowPostViewHolder extends PostViewHolder {


    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity) {
        super(view, onClickListener, activity);
    }

    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity, boolean isAuthorNeeded) {
        super(view, onClickListener, activity, isAuthorNeeded);
    }

    public void bindData(FollowingPost followingPost) {
        postManager.getSinglePostValue(followingPost.getPostId(), new OnPostChangedListener() {
            @Override
            public void onObjectChanged(Post obj) {
                bindData(obj);
            }

            @Override
            public void onError(String errorText) {
                LogUtil.logError(TAG, "bindData", new RuntimeException(errorText));
            }
        });
    }

}
