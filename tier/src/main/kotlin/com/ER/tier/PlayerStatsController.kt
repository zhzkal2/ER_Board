package com.ER.tier

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player-stats")
class PlayerStatsController(private val playerStatsService: PlayerStatsService) {

    @GetMapping
    fun getAllPlayerStats(): ResponseEntity<List<PlayerStats>> {
        val playerStatsList = playerStatsService.getAllPlayerStats()
        return ResponseEntity.ok(playerStatsList)
    }

    @GetMapping("/{id}")
    fun getPlayerStatsById(@PathVariable id: Long): ResponseEntity<PlayerStats> {
        val playerStats = playerStatsService.getPlayerStatsById(id)
        return if (playerStats != null) {
            ResponseEntity.ok(playerStats)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping
    fun createPlayerStats(@RequestBody playerStats: PlayerStats): ResponseEntity<PlayerStats> {
        val createdPlayerStats = playerStatsService.createPlayerStats(playerStats)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayerStats)
    }
}