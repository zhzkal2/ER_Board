package com.ER.tier

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebCrawlController(private val CrawlService: CrawlService) {




    @GetMapping("/crawl")
    fun crawl(@RequestParam url: String): List<String> {
        return try {
            CrawlService.crawlWebsite(url)
        } catch (e: Exception) {
            e.printStackTrace()
            listOf("Error: Unable to crawl the website.")
        }
    }
}