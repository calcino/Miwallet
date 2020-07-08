package com.calcino.miwallet.db.entity

import com.calcino.miwallet.utils.expandableRecyclerview.models.ExpandableGroup


class AccountName(title: String?, balance: Long?, items: List<AccountChild?>?) :
    ExpandableGroup<AccountChild?>(
        title,
        balance,
        items
    )