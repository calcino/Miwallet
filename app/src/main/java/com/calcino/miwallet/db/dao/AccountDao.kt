package com.calcino.miwallet.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.calcino.miwallet.db.entity.Account

@Dao
interface AccountDao:BaseDao<Account>{
    @Query("SELECT * FROM account")
    fun getAccountList(): LiveData<Account>
}