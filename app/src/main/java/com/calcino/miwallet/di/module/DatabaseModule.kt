package com.calcino.miwallet.di.module

import com.calcino.miwallet.db.MiWalletDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesAccountDao(db: MiWalletDatabase) = db.accountDao()

}