package machaca.ventura.gestordetareas


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class NotaRepository(context: Context) {

    private val dbHelper = DataBaseHelper(context)

    fun addNota(nota: Nota) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DataBaseHelper.COLUMN_TITULO, nota.titulo)
            put(DataBaseHelper.COLUMN_CONTENIDO, nota.contenido)
            put(DataBaseHelper.COLUMN_FECHA, nota.fecha)
        }
        db.insert(DataBaseHelper.TABLE_NOTAS, null, values)
        db.close()
    }

    fun getAllNotas(): List<Nota> {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            DataBaseHelper.TABLE_NOTAS,
            null, null, null, null, null, null
        )

        val notas = mutableListOf<Nota>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DataBaseHelper.COLUMN_ID))
                val titulo = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_TITULO))
                val contenido = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_CONTENIDO))
                val fecha = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_FECHA))
                val hora = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_HORA))

                notas.add(Nota(id, titulo, contenido, fecha))
            }
        }
        cursor.close()
        db.close()

        return notas
    }

    fun getNota(id: Int): Nota? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            DataBaseHelper.TABLE_NOTAS,
            null,
            "${DataBaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        var nota: Nota? = null
        with(cursor) {
            if (moveToFirst()) {
                val titulo = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_TITULO))
                val contenido = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_CONTENIDO))
                val fecha = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_FECHA))
                val hora = getString(getColumnIndexOrThrow(DataBaseHelper.COLUMN_HORA))

                nota = Nota(id, titulo, contenido, fecha)
            }
        }
        cursor.close()
        db.close()

        return nota
    }

    fun updateNota(nota: Nota) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DataBaseHelper.COLUMN_TITULO, nota.titulo)
            put(DataBaseHelper.COLUMN_CONTENIDO, nota.contenido)
            put(DataBaseHelper.COLUMN_FECHA, nota.fecha)
        }

        db.update(
            DataBaseHelper.TABLE_NOTAS,
            values,
            "${DataBaseHelper.COLUMN_ID} = ?",
            arrayOf(nota.id.toString())
        )
        db.close()
    }

    fun deleteNota(id: Int) {
        val db = dbHelper.writableDatabase
        db.delete(
            DataBaseHelper.TABLE_NOTAS,
            "${DataBaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString())
        )
        db.close()
    }
}




