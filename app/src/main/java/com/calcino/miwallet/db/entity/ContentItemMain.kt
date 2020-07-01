package com.calcino.miwallet.db.entity

class ContentItemMain : ListItemMain() {
    override var title: String? = null
    override var subtitle: String? = null
    var cost: Int? = null
    var date: String? = null
}