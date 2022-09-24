package com.example.a1ermomentoevamovil

class Product(
    val name: String,
    val price: Int,
    val newOrOld: Boolean
): ManageData {
    //Código se inicializa con una función

    var cod: Int = 0

    init {
        cod = calculateCode((5..20).random())
    }

    //Mostrar informacion y calcular el código

    override fun calculateCode(n: Int): Int {
        return 5 + (3 * (n - 1))
    }

    override fun showInformation(): String {
        return """
            El producto registrado es: $name.
            Tiene un precio de: $price Bs.
            ${if (newOrOld) "El producto es nuevo en el inventario." 
            else "El producto ya existía en el inventario."}
            Su código de registro es: ${this.cod}.
            [El producto fue registrado correctamente]
        """.trimIndent()
    }
}