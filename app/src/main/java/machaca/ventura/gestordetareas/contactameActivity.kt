package machaca.ventura.gestordetareas



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class contactameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactame)


        val facebookImageView = findViewById<ImageView>(R.id.facebookImageView)
        val twitterImageView = findViewById<ImageView>(R.id.twitterImageView)
        val emailImageView = findViewById<ImageView>(R.id.emailImageView)
        val phoneImageView = findViewById<ImageView>(R.id.phoneImageView)

        val facebookTextView = findViewById<TextView>(R.id.facebookTextView)
        val twitterTextView = findViewById<TextView>(R.id.twitterTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)


        val facebookUrl = "https://www.facebook.com/tuperfil"
        val twitterUrl = "https://www.twitter.com/tuperfil"
        val emailUrl = "mailto:tuemail@dominio.com"
        val phoneUrl = "tel:+123456789"

        // Configurar OnClickListeners
        facebookImageView.setOnClickListener { openUrl(facebookUrl) }
        facebookTextView.setOnClickListener { openUrl(facebookUrl) }

        twitterImageView.setOnClickListener { openUrl(twitterUrl) }
        twitterTextView.setOnClickListener { openUrl(twitterUrl) }

        emailImageView.setOnClickListener { openUrl(emailUrl) }
        emailTextView.setOnClickListener { openUrl(emailUrl) }

        phoneImageView.setOnClickListener { openUrl(phoneUrl) }
        phoneTextView.setOnClickListener { openUrl(phoneUrl) }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}