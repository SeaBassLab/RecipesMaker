import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val ingredients: List<String> = listOf(
        "Agua",
        "Leche",
        "Azucar",
        "Sal",
        "Huevo",
        "Harina",
        "Levadura",
        "Polvo de Hornear",
        "Vainilla",
        "Salir de ingredientes"
    )
    val ingredientesGuardados: MutableList<String> = mutableListOf<String>()
    var prep: String = ""
    var receta: String = ""

    fun initRecipesMaker() {
        fun makeRecipes() {
            println("Nombre de la receta?")

            val response = readLine()

            response.also { receta = it.toString() }

            if (response != null) {
                ing@do {
                    println("Elije los ingredientes por su numero")
                    for ((index, i) in ingredients.withIndex()) {
                        println("$index: $i")
                    }
                    val ingResponse = readLine()

                    when (ingResponse?.toInt()) {
                        0 -> ingredientesGuardados.add("Agua")
                        1 -> ingredientesGuardados.add("Leche")
                        2 -> ingredientesGuardados.add("Azucar")
                        3 -> ingredientesGuardados.add("Sal")
                        4 -> ingredientesGuardados.add("Huevo")
                        5 -> ingredientesGuardados.add("Harina")
                        6 -> ingredientesGuardados.add("Levadura")
                        7 -> ingredientesGuardados.add("Polvo de Hornear")
                        8 -> ingredientesGuardados.add("Vainilla")
                        else -> continue@ing

                    }
                } while (ingResponse?.toInt()!! <= 8)

                println("Describa la forma de preparar su receta")

                val prepResponse = readLine()

                prepResponse.also { prep = it.toString() }

                initRecipesMaker()

            }
        }


        fun showRecipes() {
            val recetasUI = """
              Receta: $receta
              ingredientes: $ingredientesGuardados
              Preparación: $prep
            """.trimIndent()
            println(recetasUI)

            initRecipesMaker()
        }

        fun endProgram() {
            println("Gracias por utilizar Recipes Maker")
        }

        val inicio = """
       ***Bienvenido a Recipes Maker***
       
       *****Seleccione una opcoión*****
       
       1. Crear una receta
       2. Ver mis recetas
       3. Salir
       """.trimIndent()
        println(inicio)

        val response = readLine()

        when (response?.toInt()) {
            1 -> makeRecipes()
            2 -> showRecipes()
            3 -> endProgram()
        }

    }
    initRecipesMaker()
}