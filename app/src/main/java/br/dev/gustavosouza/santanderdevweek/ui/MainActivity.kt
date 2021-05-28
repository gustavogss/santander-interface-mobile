package br.dev.gustavosouza.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.dev.gustavosouza.santanderdevweek.R
import br.dev.gustavosouza.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModal: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModal = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente(){
        mainViewModal.buscarContaCliente().observe(this, Observer{ result ->
            objetos(result);
        })
    }

    private fun objetos(conta: Conta){
        findViewById<TextView>(R.id.tvagencia).text = conta.agencia
        findViewById<TextView>(R.id.tvconta).text = conta.numero
        findViewById<TextView>(R.id.tvsaldodisponivel).text = conta.saldo
        findViewById<TextView>(R.id.tvtotal).text = conta.limite
        findViewById<TextView>(R.id.tvusuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.txtnumerocartao).text = conta.cartao.numeroConta
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                Log.d("CLICK", "CLICK no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}