package com.loh.tally.ui.presentations.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.loh.tally.ui.base.dagger.scope.ViewScope;
import com.loh.tally.ui.chat.detail.fragment.ChatDetailFragment;
import com.loh.tally.ui.presentations.list.fragment.PresentationListFragment;

/**
 * File: PresentationPagerAdapter.java
 * Date: 11/03/2017
 * Created By: Liam O'Hanlon
 * Description: TODO:
 */
@ViewScope
public class PresentationPagerAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_PRESENTATIONS = 0;
    public static final int FRAGMENT_CHAT = 1;

    public PresentationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case FRAGMENT_PRESENTATIONS:
                return PresentationListFragment.newInstance();

            case FRAGMENT_CHAT:
                return ChatDetailFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
