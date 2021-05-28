package br.dev.gustavosouza.santanderdevweek.data.local

import br.dev.gustavosouza.santanderdevweek.data.Cartao
import br.dev.gustavosouza.santanderdevweek.data.Cliente
import br.dev.gustavosouza.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData() : Conta {
        val cliente = Cliente("Gustavo")
        val cartao = Cartao("123456789")
       return Conta(
                "1111111-1",
                "9999-9",
                "R$ 7.500,00",
                "R$ 9.000,00",
                cliente,
                cartao
        );
    }
}