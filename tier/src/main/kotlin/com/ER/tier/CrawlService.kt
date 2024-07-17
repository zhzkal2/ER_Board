package com.ER.tier

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.stereotype.Service

@Service
class CrawlService {

    fun crawlWebsite(url: String): List<String> {
        System.setProperty("webdriver.chrome.driver", "C:\\spring\\tier\\driver\\chromedriver.exe");


        // 웹 드라이버 초기화
        val driver: WebDriver = ChromeDriver()
        val result = mutableListOf<String>()

        try {
            driver.get(url)

            // 모든 tr 태그 가져오기
            val rows = driver.findElements(By.tagName("tr"))

            for (row in rows) {
                // tr 내의 텍스트 가져오기
                val text = row.text

                // 화살표 이미지 찾기
                val arrowImg = row.findElements(By.tagName("img"))
                    .firstOrNull { it.getAttribute("alt").contains("arrow", ignoreCase = true) }

                // 화살표 alt 가져오기
                val arrowAlt = arrowImg?.getAttribute("alt") ?: "No arrow"
                result.add("$text: $arrowAlt") // 포맷팅하여 추가



//                // 결과 리스트에 추가
//                result.add(Pair(text, arrowAlt))
            }
        } finally {
            driver.quit()
        }


        return result
    }

}