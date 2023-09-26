# Proyecto Integrador semana 2 - Grupo Fannog

## Integrantes

- Daniel Dos Santos
- Franco Cossatti
- Jonathan Esponda
- Martín Garré
- Marcos Cianzio
- Facundo Suárez

## Tecnologías y librerías utilizadas

- `Kotlin`
- `Navigation Component`

## Funcionalidades

**Agregar Producto**: Navega a la pantalla de entrada y rellena los campos de texto con el nombre y el precio del producto. Presiona el botón "Agregar" para añadir el producto a la lista.

**Ver lista de productos**: Navega a la pantalla de la lista para ver todos los productos añadidos.

> Se agrego validación de campos.

## Estructura

**Model**: Define la estructura de datos del producto.

**View**: Contiene los fragmentos `ProductInputFragment` y `ProductListFragment` para las pantallas de entrada y lista, respectivamente. `MainActivity` es el container del `Navigation Component`

**ViewModel**: Contiene la lógica de presentación y maneja la actualización de la UI.

**Repository**: Encapsula toda la lógica para acceder a los datos del producto.
