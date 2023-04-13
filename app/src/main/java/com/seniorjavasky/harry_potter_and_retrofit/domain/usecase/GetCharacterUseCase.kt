package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel

class GetCharacterUseCase(
    private val repo: CharacterRepository
) {
    suspend fun getCharacter(id:Int=1):CharacterModel{
        return repo.getCharacterById(id)
    }
}