package machaca.ventura.gestordetareas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class bienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val btnMostrar:ImageView=findViewById(R.id.notesImageView)

        findViewById<ImageView>(R.id.addImageView).setOnClickListener {
            Log.d("bienvenidaActivity", "Add ImageView clicked")
            val intent = Intent(this, agregarTareaActivity::class.java)
            startActivity(intent)
        }
        btnMostrar.setOnClickListener{
            startActivity(Intent(this, MostrarNotasActivity::class.java))

        }

        findViewById<ImageView>(R.id.importantImageView).setOnClickListener {
            Log.d("bienvenidaActivity", "Important ImageView clicked")
            val intent = Intent(this, importantesActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.contactsImageView).setOnClickListener {
            Log.d("bienvenidaActivity", "Contacts ImageView clicked")
            val intent = Intent(this, contactameActivity::class.java)
            startActivity(intent)
        }
    }
}
