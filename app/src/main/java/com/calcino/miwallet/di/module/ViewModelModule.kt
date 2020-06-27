package com.calcino.miwallet.di.module

import androidx.lifecycle.ViewModel
import com.calcino.miwallet.ui.dasboard.DashboardViewModel
import com.intact.moviesbox.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun bindContactViewModel(dashboardViewModel: DashboardViewModel): ViewModel
}