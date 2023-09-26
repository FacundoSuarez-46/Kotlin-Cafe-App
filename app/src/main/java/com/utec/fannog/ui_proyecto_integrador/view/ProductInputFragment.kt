package com.utec.fannog.ui_proyecto_integrador.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.utec.fannog.ui_proyecto_integrador.R
import com.utec.fannog.ui_proyecto_integrador.model.ProductRepository
import com.utec.fannog.ui_proyecto_integrador.viewmodel.ProductViewModel


class ProductInputFragment : Fragment(R.layout.fragment_product_input) {
    private lateinit var productViewModel: ProductViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(requireActivity())[ProductViewModel::class.java]

        val btnAddProduct = requireView().findViewById<Button>(R.id.buttonAddProduct)

        btnAddProduct.setOnClickListener {
            val productName = requireView().findViewById<EditText>(R.id.editTextName).text.toString().trim()
            val productPrice = requireView().findViewById<EditText>(R.id.editTextPrice).text.toString().trim()

            if(productName.isBlank() || productPrice.isBlank()) {
                Toast.makeText(context, "Los campos no pueden estar vacios", Toast.LENGTH_LONG).show()
                return@setOnClickListener;
            }

            ProductRepository.add(productName, productPrice.toInt())
            productViewModel.refreshProductList()

            Toast.makeText(context, "Producto " +productName+ " agregado", Toast.LENGTH_LONG).show()
        }

        val btnNavigateToList = requireView().findViewById<Button>(R.id.buttonListProducts)
        btnNavigateToList.setOnClickListener {
            findNavController().navigate(R.id.action_productInputFragment_to_productListFragment)
        }
    }
}
