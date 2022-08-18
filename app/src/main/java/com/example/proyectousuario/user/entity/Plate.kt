package com.example.proyectousuario.user.entity

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class Plate(
    var id: Int,
    var sourceName: String,
    var title: String,
    var image: String,
    var pricePerServing: Double,
    var glutenFree: Boolean,
    var extendedIngredients: Array<Any>?
) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(

        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readBoolean(),
        parcel.readArray()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(sourceName)
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeDouble(pricePerServing)
        parcel.writeByte(if (glutenFree)1 else 0)
        parcel.writeArray(extendedIngredients)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plate> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Plate {
            return Plate(parcel)
        }

        override fun newArray(size: Int): Array<Plate?> {
            return arrayOfNulls(size)
        }
    }

}

/*fun getPlaceHolderItems(contex: Context): List<Plate> {

    return listOf(
        Plate(
            "Ensalada",
            30.0,
            R.drawable.assorted_sliced_fruits_in_white_ceramic_bowl_1092730_1,
            arrayOf("2 paltas", "una pizca de sal"),
            "Deliciosa Ensalada",
            5.0,
            true,
            hasFreeDelivery = false
        ),
        Plate(
            "Ensalada",
            30.0,
            R.drawable.assorted_sliced_fruits_in_white_ceramic_bowl_1092730_1,
            arrayOf("2 paltas", "una pizca de sal"),
            "Deliciosa Ensalada",
            5.0,
            true,
            hasFreeDelivery = false
        ),
        Plate(
            "Ensalada",
            30.0,
            R.drawable.assorted_sliced_fruits_in_white_ceramic_bowl_1092730_1,
            arrayOf("2 paltas", "una pizca de sal"),
            "Deliciosa Ensalada",
            5.0,
            true,
            hasFreeDelivery = false
        ),
        Plate(
            "Ensalada",
            30.0,
            R.drawable.assorted_sliced_fruits_in_white_ceramic_bowl_1092730_1,
            arrayOf("2 paltas", "una pizca de sal"),
            "Deliciosa Ensalada",
            5.0,
            true,
            hasFreeDelivery = false
        ),
        Plate(
            "Ensalada",
            30.0,
            R.drawable.assorted_sliced_fruits_in_white_ceramic_bowl_1092730_1,
            arrayOf("2 paltas", "una pizca de sal"),
            "Deliciosa Ensalada",
            5.0,
            true,
            hasFreeDelivery = false
        ),
    )
}

 */