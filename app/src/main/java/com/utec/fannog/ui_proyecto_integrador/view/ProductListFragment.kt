package com.utec.fannog.ui_proyecto_integrador.view

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.utec.fannog.ui_proyecto_integrador.R
import com.utec.fannog.ui_proyecto_integrador.viewmodel.ProductViewModel

class ProductListFragment : Fragment(R.layout.fragment_product_list) {
    private lateinit var productViewModel: ProductViewModel
    private lateinit var productsListView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(requireActivity())[ProductViewModel::class.java]
        productsListView = requireView().findViewById(R.id.listViewProducts)

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            val list = products.map { "${it.id}: ${it.name} - $${it.price}" }
            val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
            productsListView.adapter = arrayAdapter
        }

        val btnGoBack = requireView().findViewById<Button>(R.id.buttonBack)

        btnGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_productListFragment_to_productInputFragment)
        }
    }
}