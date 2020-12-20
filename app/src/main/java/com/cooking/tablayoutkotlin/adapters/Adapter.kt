package com.cooking.tablayoutkotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cooking.tablayoutkotlin.food_fragment.*


class Adapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)  {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Ricef()
            1 -> Noodlesf()
            2 -> Meatf()
            3 -> Soupf()
            4 -> Vegetablef()
            5 -> Fruitf()
            6 -> Dessertf()
            7 -> Breakfastf()
            8 -> Easyf()
            else -> Sidedishf()
        }
    }

    override fun getCount(): Int {
        return 10
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position){
            0 -> "飯食"
            1 -> "麵食"
            2 -> "肉類"
            3 -> "湯品"
            4 -> "蔬菜"
            5 -> "水果"
            6 -> "甜點"
            7 -> "早餐"
            8 -> "便當"
            else -> "備餐"
        }
    }
}