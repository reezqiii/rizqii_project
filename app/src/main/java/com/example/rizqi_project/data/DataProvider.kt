package com.example.rizqi_project.data

import com.example.rizqi_project.R

object DataProvider {

        val food =
            Food(
                id = 1,
                name = "Dimsum Setan",
                category = "Makanan Pedas Pangsit",
                price = 20.00,
                description = "Dimsum Setan menawarkan berbagai jenis dimsum, seperti siomay, udang keju, dan lumpia kulit tahu. Setiap jenis dimsum disiapkan dengan bahan berkualitas tinggi dan resep yang telah disempurnakan untuk memberikan rasa yang otentik.",
                foodImageId = R.drawable.p1
            )

        val foodList = listOf(
            food,
            Food(
                id = 2,
                name = "Ceker Mercon",
                category = "Makanan Pedas Ceker",
                price = 15.00,
                description = "Hidangan ini sangat populer di kalangan masyarakat Indonesia, terutama bagi mereka yang menyukai tantangan kuliner dengan rasa pedas. Ceker Mercon dapat ditemukan di berbagai warung makan, restoran, dan juga tersedia dalam bentuk frozen untuk dinikmati di rumah.",
                foodImageId = R.drawable.p2
            ),
            Food(
                id = 3,
                name = "Seblak Sunda",
                category = "Makanan Pedas Kerupuk/Mie Basah",
                price = 35.00,
                description = "Rasa seblak sangat pedas dengan sentuhan gurih dari bumbu rempah. Kencur menjadi salah satu bahan yang membedakan seblak dari masakan lainnya, memberikan rasa yang segar dan khas.",
                foodImageId = R.drawable.p3
            ),
            Food(
                id = 4,
                name = "Kimchi Cabe-cabean",
                category = "Makanan Pedas Korea",
                price = 40.00,
                description = "Kimchi adalah makanan tradisional Korea yang terkenal sebagai asinan sayur hasil fermentasi. Hidangan ini biasanya terbuat dari sayuran seperti sawi putih dan lobak, yang dicampur dengan bumbu pedas yang kaya rasa. Proses pembuatan kimchi melibatkan penggaraman sayuran, diikuti dengan pencampuran bumbu yang terdiri dari bawang putih, jahe, udang krill, kecap ikan, dan bubuk cabai merah.",
                foodImageId = R.drawable.p4
            ),
            Food(
                id = 5,
                name = "Bakso Mercon",
                category = "Makanan Pedas Bakso Kerikil",
                price = 35.00,
                description = "Nama \"Mercon\" berasal dari bahasa Indonesia yang berarti \"petasan\", mengacu pada sensasi pedas yang meledak di mulut saat menikmati bakso ini. Rasa pedasnya berasal dari cabai rawit setan yang dihaluskan dan dicampurkan ke dalam adonan bakso serta sambal yang menyertainya.",
                foodImageId = R.drawable.p5
            ),
            Food(
                id = 6,
                name = "Basreng Molotop",
                category = "Makanan Pedas Kerupuk Kering",
                price = 50.00,
                description = "Salah satu daya tarik utama dari Basreng Molotop adalah tingkat kepedasannya. Camilan ini biasanya disajikan dengan taburan bumbu pedas yang bervariasi, memungkinkan penikmatnya untuk memilih tingkat kepedasan sesuai selera. Beberapa varian rasa juga tersedia, termasuk keju dan rumput laut, menambah variasi pengalaman rasa.",
                foodImageId = R.drawable.p6
            ),
            Food(
                id = 7,
                name = "Makaroni Gila",
                category = "Makanan Pedas Makaroni",
                price = 25.00,
                description = "Makaroni pedas adalah camilan yang terbuat dari makaroni kering yang dibumbui dengan bumbu pedas. Makaroni pedas memiliki tekstur yang keras dan gurih, serta memiliki rasa yang khas dan berbeda dengan makaroni biasa. Makaroni pedas bisa dijadikan camilan atau pelengkap bubur dan makanan berkuah lainnya.",
                foodImageId = R.drawable.p7
            ),
            Food(
                id = 8,
                name = "Ayam Suwir Setan",
                category = "Makanan Pedas Ayam Kemangi",
                price = 20.00,
                description = "Ayam Suwir Cabe Setan adalah hidangan pedas yang menggugah selera, terbuat dari daging ayam yang dimasak dengan bumbu cabai yang sangat pedas. Hidangan ini dikenal karena cita rasanya yang kuat dan pedas, cocok bagi pecinta makanan yang menyukai tantangan.",
                foodImageId = R.drawable.p8
            ),
            Food(
                id = 9,
                name = "Ayam Geprek",
                category = "Makanan Pedas Ayam Geprek",
                price = 27.00,
                description = "Keunikan dari Ayam Geprek Kebakar adalah proses pembakarannya setelah digoreng, memberikan aroma smoky yang khas dan rasa yang lebih dalam.",
                foodImageId = R.drawable.p9
            ),
            Food(
                id = 10,
                name = "Usus Ayam Kebakar",
                category = "Makanan Pedas Usus Ayam",
                price = 55.00,
                description = "Usus Ayam Kebakaran adalah camilan unik yang terbuat dari usus ayam yang dibumbui dan digoreng hingga garing. Proses memasaknya melibatkan marinasi usus dengan bumbu-bumbu khas seperti bawang putih, cabai, dan rempah-rempah sebelum digoreng hingga renyah.",
                foodImageId = R.drawable.p10
            )
        )
    }
