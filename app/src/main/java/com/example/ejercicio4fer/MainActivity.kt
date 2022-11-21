package com.example.ejercicio4fer

import com.example.ejercicio4fer.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mAdapter by lazy { RecyclerAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {

        binding.rvCharacters.apply {

            setHasFixedSize(true)

            layoutManager = GridLayoutManager(this@MainActivity,2)

            adapter = mAdapter

            mAdapter.setData(getAnimals(), this@MainActivity)
        }
    }

    private fun getAnimals(): MutableList<Characters> {
        val characters: MutableList<Characters> = arrayListOf()

        characters.add(Characters(getString(R.string.goku), getString(R.string.gokuDesc), R.drawable.goku))
        characters.add(Characters(getString(R.string.vegeta), getString(R.string.vegetaDesc), R.drawable.vegeta))
        characters.add(Characters(getString(R.string.frieza), getString(R.string.friezaDesc), R.drawable.frieza))
        characters.add(Characters(getString(R.string.android18), getString(R.string.androidDesc), R.drawable.android18))
        characters.add(Characters(getString(R.string.gamma1and2), getString(R.string.gammasDesc), R.drawable.gamma1and2))
        characters.add(Characters(getString(R.string.gogeta), getString(R.string.gogetaDesc), R.drawable.gogeta))
        characters.add(Characters(getString(R.string.vegito), getString(R.string.vegitoDesc), R.drawable.vegito))
        characters.add(Characters(getString(R.string.piccolo), getString(R.string.piccoloDesc), R.drawable.piccolo))
        characters.add(Characters(getString(R.string.omega), getString(R.string.omegaDesc), R.drawable.omega))
        characters.add(Characters(getString(R.string.cell), getString(R.string.cellDesc), R.drawable.cell))

        return characters
    }

     override fun onItemClickListener(character: Characters) {
         Snackbar.make(findViewById(R.id.root_layout),character.name,Snackbar.LENGTH_SHORT).show()
    }
}