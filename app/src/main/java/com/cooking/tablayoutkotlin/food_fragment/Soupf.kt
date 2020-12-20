package com.cooking.tablayoutkotlin.food_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cooking.tablayoutkotlin.R
import com.cooking.tablayoutkotlin.adapters.FooditemsAdapter
import com.cooking.tablayoutkotlin.model.Fooditems

class Soupf : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList:ArrayList<Fooditems> ? = null
    private var foodiesAdapters: FooditemsAdapter? = null

    // initialize adapter in onCreate, it's unaffected by views state
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // initialize recyclerView and layout manager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.soup_recycler_view)

        // design the gridlayout count/row
        gridLayoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        arrayList = ArrayList()
        arrayList = setDataInList()

        foodiesAdapters = FooditemsAdapter(requireContext(), arrayList!!)
        recyclerView?.adapter = foodiesAdapters

    }

    //顯示soup_layout的介面
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.soup_layout, container, false)
    }


    private fun setDataInList(): ArrayList<Fooditems>? {
        var items : ArrayList<Fooditems> = ArrayList()
        items.add(Fooditems(R.drawable.letter_i , alphaChar = "Char I"))
        items.add(Fooditems(R.drawable.letter_h , alphaChar = "Char H"))
        items.add(Fooditems(R.drawable.letter_g , alphaChar = "Char G"))
        items.add(Fooditems(R.drawable.letter_f , alphaChar = "Char F"))
        items.add(Fooditems(R.drawable.letter_e , alphaChar = "Char E"))
        items.add(Fooditems(R.drawable.letter_d , alphaChar = "Char D"))
        items.add(Fooditems(R.drawable.letter_c , alphaChar = "Char C"))
        items.add(Fooditems(R.drawable.letter_b , alphaChar = "Char B"))
        items.add(Fooditems(R.drawable.letter_a , alphaChar = "Char A"))

        return items
    }
}
