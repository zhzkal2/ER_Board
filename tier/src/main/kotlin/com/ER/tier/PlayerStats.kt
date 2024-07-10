package com.ER.tier

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class PlayerStats(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,//실험체명 : 저격총 카티야
    val rp: Float, //점수 획득량 : -0.8
    val pickRate: Float,//픽률 : 3.23%
    val winRate: Float, //승률 : 16.67
    val top3Rate: Float, //Top3 확률 : 40.00
    val averageRank: Float, //평균랭크 : 4.3
    val damage: Int, //대미지 : 17,776
    val tk: Float, //평균킬수7.73
    val monsterKill: Float //평균 몬스터킬  47.38 //점수배율

)
