package com.example.cafe_user.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cafe_user.R
<<<<<<< HEAD
=======
import com.example.cafe_user.ui.order.*
>>>>>>> e66e696c329b8175230bb9172e70e91a85031276
import kotlinx.android.synthetic.main.order_screen.*

class OrderFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.order_screen, container, false)

        return view
    }

    var CoffeeView: CoffeeFragment? = null
    var JuiceView: JuiceFragment? = null
    var SmoothieView: SmoothieFragment? = null
    var BreadView: BreadFragment? = null
    var DessertView: DessertFragment? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoffeeView = CoffeeFragment()
        JuiceView = JuiceFragment()
        SmoothieView = SmoothieFragment()
        BreadView = BreadFragment()
        DessertView = DessertFragment()

        val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,CoffeeView!!).commit()

        category_coffee.setOnClickListener{
            val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,CoffeeView!!).commit()
        }
        category_juice.setOnClickListener{
            val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,JuiceView!!).commit()
        }
        category_smoothie.setOnClickListener {
            val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,SmoothieView!!).commit()
        }
        category_bread.setOnClickListener {
            val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,BreadView!!).commit()
        }
        category_dessert.setOnClickListener {
            val manager = childFragmentManager.beginTransaction().replace(R.id.order_menu_fragment,DessertView!!).commit()
        }
    }
}