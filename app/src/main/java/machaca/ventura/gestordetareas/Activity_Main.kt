
package machaca.ventura.gestordetareas

// MainActivity.kt
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
//
//    private lateinit var notaRepository: NotaRepository
//    private lateinit var notaAdapter: NotaAdapter
//    private lateinit var editTextTitulo: EditText
//    private lateinit var editTextContenido: EditText
//    private lateinit var editTextFecha: EditText
//    private lateinit var editTextHora: EditText
//    private lateinit var buttonGuardar: Button
//    private lateinit var recyclerView: RecyclerView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        notaRepository = NotaRepository(this)
//        notaAdapter = NotaAdapter(listOf())
//
//        editTextTitulo = findViewById(R.id.editTextTitulo)
//        editTextContenido = findViewById(R.id.editTextContenido)
//        editTextFecha = findViewById(R.id.editTextFecha)
//        editTextHora = findViewById(R.id.editTextHora)
//        buttonGuardar = findViewById(R.id.buttonGuardar)
//        recyclerView = findViewById(R.id.recyclerView)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = notaAdapter
//
//        buttonGuardar.setOnClickListener {
//            val titulo = editTextTitulo.text.toString()
//            val contenido = editTextContenido.text.toString()
//            val fecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
//
//            val nota = Nota(
//                id = 0,
//                titulo = titulo,
//                contenido = contenido,
//                fecha=fecha
//            )
//            notaRepository.addNota(nota)
//            actualizarNotas()
//        }
//
//        actualizarNotas()
//    }
//
//    private fun actualizarNotas() {
//        val notas = notaRepository.getAllNotas()
//        Log.d("MainActivity", "Notas cargadas: $notas") // Log para depuración
//        //notaAdapter.updateNotas(notas)
//    }
}



