package machaca.ventura.gestordetareas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotaAdapter(private val notaList: List<Nota>) : RecyclerView.Adapter<NotaAdapter.NotaViewHolder>() {

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
        val contenidoTextView: TextView = itemView.findViewById(R.id.contenidoTextView)
        val fechaTextView: TextView = itemView.findViewById(R.id.fechaTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val currentNota = notaList[position]
        holder.tituloTextView.text = currentNota.titulo
        holder.contenidoTextView.text = currentNota.contenido
        holder.fechaTextView.text = currentNota.fecha.toString()
    }

    override fun getItemCount() = notaList.size
}
