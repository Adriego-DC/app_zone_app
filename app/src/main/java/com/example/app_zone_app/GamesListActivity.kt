package com.example.app_zone_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class GamesListActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var adapter: GameAdapter
    private lateinit var gameList: MutableList<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGames)
        recyclerView.layoutManager = LinearLayoutManager(this)

        gameList = mutableListOf()
        adapter = GameAdapter(gameList)
        recyclerView.adapter = adapter

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        loadGames()
    }

    private fun loadGames() {
        val userId = auth.currentUser?.uid ?: return
        val gamesRef = database.child("games").child(userId)

        gamesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                gameList.clear()
                for (gameSnapshot in snapshot.children) {
                    val game = gameSnapshot.getValue(Game::class.java)
                    game?.let { gameList.add(it) }
                }
                adapter.updateGames(gameList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Mostrar error
            }
        })
    }
}
