package com.ER.tier

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class CrawlService {
    fun crawlWebsite(url: String): List<String> {
        val result = mutableListOf<String>()
        val doc = Jsoup.connect(url).get()
        val tbody = doc.select("th")
        result.add("HTML Content:")
        result.add(tbody.outerHtml())

//
//        for (tableBody  in tbody) {
//            val rows = tableBody.select("tr") // tbody 내부의 tr 태그 선택
//            for (row in rows) {
//                // 각 tr 태그의 class 속성을 result에 추가
//                val className = row.className()
//                result.add("Class: $className")
//
//                val cells = row.select("td, th") // tr 내부의 td와 th 태그 선택
//                val cellData = cells.joinToString(separator = " | ") { it.text() }
//                result.add("Row: $cellData")
//            }
//
//        }
        return result
    }
}