package com.utec.fannog.ui_proyecto_integrador.model

object ProductRepository {
    private val products = mutableListOf<Product>()

    fun add(name: String, price: Int) {
        val id = products.size + 1
        val newProduct = Product(id, name, price)
        products.add(newProduct)
    }

    fun getAll(): MutableList<Product> {
        return products
    }
}