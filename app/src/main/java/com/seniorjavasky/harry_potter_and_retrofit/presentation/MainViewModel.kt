package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.data.network.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.logging.HttpLoggingInterceptor

private const val TAG = "MainViewModel555"

class MainViewModel(
    private val reposotory: CharacterRepositoryImpl,
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val getCharacterUseCase: GetCharacterUseCase
) :  ViewModel() {


    private var _character: MutableStateFlow<CharacterModel> =
        MutableStateFlow<CharacterModel>(CharacterModel())
    var character = _character.asStateFlow()
    private var _characterList: MutableStateFlow<List<CharacterModel>> =
        MutableStateFlow<List<CharacterModel>>(mutableListOf())
    var characterList = _characterList.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _character.value = getCharacterUseCase.getCharacter()
                _characterList.value = getCharacterListUseCase.getCharacterList()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}: ", t)
            }
        }
    }

    fun randomCharacter() {
        _character.value = _characterList.value.random()
    }
}