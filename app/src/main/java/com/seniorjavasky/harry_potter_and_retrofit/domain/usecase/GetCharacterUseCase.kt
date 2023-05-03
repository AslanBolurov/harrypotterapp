package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val repo: CharacterRepository
) {
    suspend operator fun invoke(id: Int = 1) = repo.getCharacterById(id)
}