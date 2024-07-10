package com.ER.tier

import org.springframework.data.jpa.repository.JpaRepository

interface PlayerStatsRepository : JpaRepository<PlayerStats, Long>