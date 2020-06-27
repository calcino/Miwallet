package com.calcino.miwallet.di.module

import com.calcino.miwallet.ui.dasboard.DashboardActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeDashboard() : DashboardActivity
}