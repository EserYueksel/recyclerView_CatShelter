package com.example.catshelter.data

import com.example.catshelter.R
import com.example.catshelter.data.model.Cat

class DataSource {
    fun getCats(): List<Cat> {
        return listOf(
            Cat(
                "Smirky",
                24,
                3.4,
                R.drawable.cat1
            ),
            Cat(
                "Chonker",
                36,
                5.7,
                R.drawable.cat2
            ),
            Cat(
                "Lilith",
                20,
                3.2,
                R.drawable.cat3
            ),
            Cat(
                "Stephan",
                26,
                5.2,
                R.drawable.cat4
            ),
            Cat(
                "Graf Kadsula",
                43,
                4.3,
                R.drawable.cat5
            )
        )
    }
}