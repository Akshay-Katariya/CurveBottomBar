package com.akshay.example.view;
import android.annotation.SuppressLint;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by Akshay Katariya on 15/11/18.
 */

public class BottomBarBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

    private int height;


    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, BottomNavigationView child, int layoutDirection) {
        height = child.getHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomNavigationView child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, BottomNavigationView child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (dyConsumed > 0) {
            slideDown(child);
        } else if (dyConsumed < 0) {
            slideUp(child);
        }
    }

    @SuppressLint("RestrictedApi")
    private void slideUp(BottomNavigationView child) {
        child.clearAnimation();
        child.animate().translationY(0).setDuration(200);

    }

    @SuppressLint("RestrictedApi")
    private void slideDown(BottomNavigationView child) {
        child.clearAnimation();
        child.animate().translationY(height).setDuration(200);


    }

}