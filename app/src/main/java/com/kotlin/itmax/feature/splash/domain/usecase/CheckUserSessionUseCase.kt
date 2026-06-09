package com.kotlin.itmax.feature.splash.domain.usecase

class CheckUserSessionUseCase @Inject constructor(
    private val repository: IAuthRepository
) {
    suspend operator fun invoke(): Boolean {
        // Aqui o repositório iria no banco local checar se existe um token.
        // Retornamos true (logado) ou false (não logado).
        return repository.isUserLoggedIn()
    }
}