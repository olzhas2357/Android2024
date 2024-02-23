package com.dodopizza.model

import com.dodopizza.R

object PizzaDataSource {
    val pizzaList = arrayListOf<Pizza>(
        Pizza(
            title = "Пепперони",
            description = "Пикантная пепперони, много моуареллы и томатный соус. Самая популярная пицца",
            imageRes = R.drawable.pepperoni,
            price = "от 2900 KZT"
            ),
        Pizza(
            title = "Чоризо фреш",
            description = " Томатный соус, моцарелла, острая чоризо из цыпленка, сладкий перец",
            imageRes = R.drawable.fresh,
            price = "от 2300 KZT"
        ),
        Pizza(
            title = "Сырная",
            description = "Моцарелла, сыры чеддер и пармезан, соус альфредо",
            imageRes = R.drawable.cheesse,
            price = "от 2400 KZT"

        ),
        Pizza(
            title = "Мясная",
            description = "Цыпленок, ветчина из цыпленка, пепперони из цыпленка, томатный соус, пикантная чоризо из цыпленка, моцарелла",
            imageRes = R.drawable.meets,
            price = "от 2600 KZT"

        ),
        Pizza(
            title = "Додо",
            description ="Ветчина из цыпленка, митболы из говядины, пепперони из цыпленка, моцарелла, томаты, шампиньоны, сладкий перец, красный лук, чеснок, томатный соус",
            imageRes = R.drawable.dodo,
            price = "от 2400 KZT"
        ),

        Pizza(
            title = "Аррива",
            description = "Цыпленок, острая чоризо, соус бургер, сладкий перец, красный лук, томаты, моцарелла, соус ранч, чеснок",
            imageRes = R.drawable.arriva,
            price = "от 2500 KZT"
        ),
        Pizza(
            title = "Диабло",
            description = "Соус бургер, цыпленок, соус ранч, чоризо из цыпленка, сладкий перец, красный лук, моцарелла, томаты, чеснок",
            imageRes = R.drawable.diablo,
            price = "от 2400 KZT"
        ),
        Pizza(
            title = "Барбекю",
            description = "Острая чоризо из цыпленка, соус барбекю, томаты, красный лук, моцарелла, томатный соус",
            imageRes = R.drawable.barbq,
            price = "от 2900 KZT"
        ),
        )

    val comboList = arrayListOf<Pizza>(
        Pizza(
            title = "Комбо за 3900 KZT",
            description = "Кому-кому только одному. Маленькая пицца, закуска, напиток и соус. Цена комбо зависит от выбранных продуктов и может быть увеличена",
            imageRes = R.drawable.combo,
            price = "3900 KZT"
        ),
        Pizza(
            title = "3 пиццы от 4900 ₸",
            description = "Настоящая дегустация. Три маленькие пиццы по суперцене. Пиццы в комбо можно менять. Цена комбо зависит от выбранных пицц и может быть увеличена",
            imageRes = R.drawable.pizzas,
            price = "4900 KZT"
        ),
        Pizza(
            title = "Пицца и 2 закуски",
            description = "Пицца 30 см и 2 закуски на выбор. Для компании из 2–4 человек. Пиццы в комбо можно менять",
            imageRes = R.drawable.pizza_snacks,
            price = "4700 KZT"
        ),
    )
}