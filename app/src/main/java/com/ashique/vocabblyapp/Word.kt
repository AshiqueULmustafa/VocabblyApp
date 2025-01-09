package com.ashique.vocabblyapp

import android.os.Parcel
import android.os.Parcelable


data class Word(
    val word: String,
    val wordStatus: Int,
    val meaning: List<String>,
    val example: List<String>,
    val options: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(word)
        parcel.writeInt(wordStatus)
        parcel.writeStringList(meaning)
        parcel.writeStringList(example)
        parcel.writeStringList(options)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Word> {
        override fun createFromParcel(parcel: Parcel): Word {
            return Word(parcel)
        }

        override fun newArray(size: Int): Array<Word?> {
            return arrayOfNulls(size)
        }
    }
}
