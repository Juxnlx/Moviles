package com.example.midiariodeviajes.viewModels

import androidx.lifecycle.ViewModel
import com.example.midiariodeviajes.data.model.Destino
import com.example.midiariodeviajes.data.model.listaDestinos

class TravelViewModel : ViewModel() {

    fun getDestinoById(id: Int): Destino? {
        return listaDestinos.find { it.id == id }
    }



}