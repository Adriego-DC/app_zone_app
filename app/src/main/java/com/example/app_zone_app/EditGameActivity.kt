package com.example.app_zone_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class EditGameActivity : AppCompatActivity() {

    private lateinit var etTitle: TextInputEditText
    private lateinit var etGenre: TextInputEditText
    private lateinit var ratingBar: RatingBar
    private lateinit var btnEdit: Button
    private lateinit var btnDelete: Button

    private lateinit var auth: FirebaseAuth
    private val db = FirebaseDatabase.getInstance().reference

    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        auth = FirebaseAuth.getInstance()

        etTitle = findViewById(R.id.etGameTitle)
        etGenre = findViewById(R.id.etGameGenre)
        ratingBar = findViewById(R.id.ratingBar)
        btnEdit = findViewById(R.id.btnEditGame)
        btnDelete = findViewById(R.id.btnDeleteGame)

        game = intent.getSerializableExtra("game") as Game

        etTitle.setText(game.title)
        etGenre.setText(game.genre)
        ratingBar.rating = game.rating

        btnEdit.setOnClickListener { editGame() }
        btnDelete.setOnClickListener { deleteGame() }
    }

    private fun editGame() {
        val updatedGame = game.copy(
            title = etTitle.text.toString(),
            genre = etGenre.text.toString(),
            rating = ratingBar.rating
        )

        val userId = auth.currentUser?.uid ?: return

        db.child("games").child(userId).child(game.id).setValue(updatedGame)
            .addOnSuccessListener {
                Toast.makeText(this, "Juego editado correctamente", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al editar juego", Toast.LENGTH_SHORT).show()
            }
    }

    private fun deleteGame() {
        val userId = auth.currentUser?.uid ?: return

        db.child("games").child(userId).child(game.id).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Juego eliminado correctamente", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al eliminar juego", Toast.LENGTH_SHORT).show()
            }
    }
}
