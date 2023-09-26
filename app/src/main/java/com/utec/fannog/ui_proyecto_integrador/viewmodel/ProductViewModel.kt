package com.utec.fannog.ui_proyecto_integrador.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utec.fannog.ui_proyecto_integrador.model.Product
import com.utec.fannog.ui_proyecto_integrador.model.ProductRepository

class ProductViewModel: ViewModel() {
    private val liveProducts = MutableLiveData<MutableList<Product>>()

    val products: LiveData<MutableList<Product>> get() = liveProducts

    init {
        refreshProductList()
    }

    fun refreshProductList() {
        liveProducts.value = ProductRepository.getAll()
    }

}