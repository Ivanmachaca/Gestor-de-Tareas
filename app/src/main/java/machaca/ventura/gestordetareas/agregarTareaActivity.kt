package machaca.ventura.gestordetareas
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Date

class agregarTareaActivity : AppCompatActivity() {

    private lateinit var tituloEditText: EditText
    private lateinit var contenidoEditText: EditText
    private lateinit var guardarNotaButton: Button

    private lateinit var db: FirebaseFirestore
    private var notaId: Int = 0 // Asume que este ID se autoincrementa de alguna manera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_tarea)

        tituloEditText = findViewById(R.id.tituloEditText)
        contenidoEditText = findViewById(R.id.contenidoEditText)
        guardarNotaButton = findViewById(R.id.guardarNotaButton)

        db = FirebaseFirestore.getInstance()

        guardarNotaButton.setOnClickListener {
            val titulo = tituloEditText.text.toString().trim()
            val contenido = contenidoEditText.text.toString().trim()
            val fecha = Date()

            if (titulo.isNotEmpty() && contenido.isNotEmpty()) {
                val nota = Nota(notaId, titulo, contenido, fecha.toString())

                db.collection("notas").add(nota)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Nota guardada exitosamente", Toast.LENGTH_SHORT).show()
                        // Aquí puedes incrementar el ID y/o limpiar los campos
                        notaId++
                        limpiarCampos()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error al guardar la nota", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun limpiarCampos() {
        tituloEditText.text.clear()
        contenidoEditText.text.clear()
    }
}
