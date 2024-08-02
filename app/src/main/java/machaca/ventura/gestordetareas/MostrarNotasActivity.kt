package machaca.ventura.gestordetareas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MostrarNotasActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var notaAdapter: NotaAdapter
    private lateinit var notaList: MutableList<Nota>
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_notas)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        notaList = mutableListOf()
        notaAdapter = NotaAdapter(notaList)
        recyclerView.adapter = notaAdapter

        db = FirebaseFirestore.getInstance()

        db.collection("notas")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val nota = document.toObject(Nota::class.java)
                    notaList.add(nota)
                }
                notaAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                // Manejar el error
            }
    }
}