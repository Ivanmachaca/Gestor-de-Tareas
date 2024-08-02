package machaca.ventura.gestordetareas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class iniciarSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciar_sesion)

        findViewById<Button>(R.id.loginButton).setOnClickListener{
            val intent = Intent(this,bienvenidaActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.registerTextView).setOnClickListener{
            val intent = Intent(this,registroActivity::class.java)
            startActivity(intent)
        }



    }
}