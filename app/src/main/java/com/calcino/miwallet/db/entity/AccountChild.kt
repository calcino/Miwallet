package com.calcino.miwallet.db.entity

import android.os.Parcel
import android.os.Parcelable

class AccountChild : Parcelable {
    var monyTransfer: String?
//    var transaction: String? = "Transactions"
//    var edit: String? = "Edit"

    constructor(MoneyTransfer: String?) {
        monyTransfer = MoneyTransfer
    }

    constructor(parcel: Parcel) {
        monyTransfer = parcel.readString()
//        transaction = parcel.readString()
//        edit = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(monyTransfer)
//        parcel.writeString(transaction)
//        parcel.writeString(edit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AccountChild> {
        override fun createFromParcel(parcel: Parcel): AccountChild {
            return AccountChild(parcel)
        }

        override fun newArray(size: Int): Array<AccountChild?> {
            return arrayOfNulls(size)
        }
    }

}