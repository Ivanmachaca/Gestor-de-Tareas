package machaca.ventura.gestordetareas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createNotasTable = """
            CREATE TABLE $TABLE_NOTAS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITULO TEXT NOT NULL,
                $COLUMN_CONTENIDO TEXT NOT NULL,
                $COLUMN_FECHA TEXT NOT NULL,
                $COLUMN_HORA TEXT NOT NULL
            )
        """.trimIndent()
        db.execSQL(createNotasTable)

        val createUsersTable = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USER_EMAIL TEXT NOT NULL UNIQUE,
                $COLUMN_USER_PASSWORD TEXT NOT NULL
            )
        """.trimIndent()
        db.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NOTAS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }
    fun obtenerNota(){

    }
    companion object {
        const val DATABASE_NAME = "notas.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NOTAS = "notas"
        const val COLUMN_ID = "id"
        const val COLUMN_TITULO = "titulo"
        const val COLUMN_CONTENIDO = "contenido"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_HORA = "hora"

        // Constants for users table
        const val TABLE_USERS = "users"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_USER_EMAIL = "email"
        const val COLUMN_USER_PASSWORD = "password"
    }
}



