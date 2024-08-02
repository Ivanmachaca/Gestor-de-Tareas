package machaca.ventura.gestordetareas

import java.util.Date

data class Nota(
    val id: Int ,
    val titulo: String,
    val contenido: String,
    val fecha: String=""
)