package com.example.android.thursdaytriviathree.data

import com.example.android.thursdaytriviathree.R
import com.example.android.thursdaytriviathree.model.Restaurant

class RestaurantList {
    fun getRestaurantList(): List<Restaurant>{
        return listOf<Restaurant>(
            Restaurant(R.drawable.res2,R.string.resName1,R.string.resDes1,R.string.resRate1,R.string.resPrice1),
            Restaurant(R.drawable.res1,R.string.resName2,R.string.resDes2,R.string.resRate2,R.string.resPrice2),
            Restaurant(R.drawable.res6,R.string.resName3,R.string.resDes3,R.string.resRate3,R.string.resPrice3),
            Restaurant(R.drawable.res4,R.string.resName4,R.string.resDes4,R.string.resRate4,R.string.resPrice4),
            Restaurant(R.drawable.res5,R.string.resName5,R.string.resDes5,R.string.resRate5,R.string.resPrice5),
            Restaurant(R.drawable.res3,R.string.resName6,R.string.resDes6,R.string.resRate6,R.string.resPrice6),
            Restaurant(R.drawable.res7,R.string.resName7,R.string.resDes7,R.string.resRate7,R.string.resPrice7),
            Restaurant(R.drawable.res8,R.string.resName8,R.string.resDes8,R.string.resRate8,R.string.resPrice8)
        )

    }
}