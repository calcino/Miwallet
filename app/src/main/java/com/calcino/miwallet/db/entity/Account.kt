package com.calcino.miwallet.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class Account(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "balance")
    val balance: Long,
    @ColumnInfo(name = "color")
    val color: Int,
    @ColumnInfo(name = "icon")
    val icon: Int,
    @ColumnInfo(name = "currency_type")
    val currency_type:Int
)


