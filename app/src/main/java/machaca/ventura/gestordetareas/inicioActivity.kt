package machaca.ventura.gestordetareas

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class inicioActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        val db = Firebase.firestore

        findViewById<Button>(R.id.registerButton).setOnClickListener{
            val intent = Intent(this,iniciarSesionActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.registerInfoButton).setOnClickListener{
            val intent = Intent(this,registroActivity::class.java)
            startActivity(intent)
        }
    }
}