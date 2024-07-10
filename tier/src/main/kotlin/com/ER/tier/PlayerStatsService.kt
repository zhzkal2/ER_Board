package com.ER.tier

import org.springframework.stereotype.Service

@Service
class PlayerStatsService(private val playerStatsRepository: PlayerStatsRepository) {

    fun getAllPlayerStats(): List<PlayerStats> {
        return playerStatsRepository.findAll()
    }

    fun getPlayerStatsById(id: Long): PlayerStats? {
        return playerStatsRepository.findById(id).orElse(null)
    }

    fun createPlayerStats(playerStats: PlayerStats): PlayerStats {
        return playerStatsRepository.save(playerStats)
    }
}