package machaca.ventura.gestordetareas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import machaca.ventura.gestordetareas.R
import machaca.ventura.gestordetareas.Usuario

class registroActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var correoEditText: EditText
    private lateinit var contraseñaEditText: EditText
    private lateinit var confirmarContraseñaEditText: EditText
    private lateinit var botonRegistrarse: Button

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombreEditText = findViewById(R.id.nombreEditText)
        correoEditText = findViewById(R.id.correoEditText)
        contraseñaEditText = findViewById(R.id.contraseñaEditText)
        confirmarContraseñaEditText = findViewById(R.id.confirmarContraseñaEditText)
        botonRegistrarse = findViewById(R.id.botonRegistrarse)

        db = FirebaseFirestore.getInstance()

        botonRegistrarse.setOnClickListener {
            val nombre = nombreEditText.text.toString().trim()
            val correo = correoEditText.text.toString().trim()
            val contraseña = contraseñaEditText.text.toString().trim()
            val confirmarContraseña = confirmarContraseñaEditText.text.toString().trim()

            if (contraseña == confirmarContraseña) {
                val usuario = Usuario(nombre, correo, contraseña)
                db.collection("usuarios").document(correo).set(usuario)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                        // Aquí puedes agregar una acción, como redirigir a otra actividad
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
