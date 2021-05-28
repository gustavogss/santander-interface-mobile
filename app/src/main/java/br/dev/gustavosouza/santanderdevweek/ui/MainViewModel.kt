package br.dev.gustavosouza.santanderdevweek.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.dev.gustavosouza.santanderdevweek.data.Conta
import br.dev.gustavosouza.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocalData()
        return mutableLiveData
    }
}