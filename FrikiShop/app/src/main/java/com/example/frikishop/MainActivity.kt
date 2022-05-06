package com.example.frikishop

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.frikishop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var navHost: NavHostFragment
    val database by lazy{ BaseDatos.getDatabase(this) }
    val miRepositorio by lazy{ Repositorio(database.miDao()) }
    val miViewModel: vm by viewModels { CineViewModelFactory(miRepositorio)}
    val vm:vm by viewModels()
    //val miViewModel: vm by viewModels { CineViewModelFactory(miRepositorio)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        when (item.itemId) {
            R.id.new_figura -> navHost.navController.navigate(R.id.action_FirstFragment_to_newFiguraFragment)
            R.id.new_user -> navHost.navController.navigate(R.id.action_FirstFragment_to_newUserFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}