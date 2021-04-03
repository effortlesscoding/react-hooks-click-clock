package com.thecodingways.clickclockweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ClickClockWebApplication

fun main(args: Array<String>) {
	runApplication<ClickClockWebApplication>(*args)
}

@RestController
class ClickClockResource {
	@GetMapping(path = ["/click-clocks"])
	fun index(): ClickClockResponse {
		val clickClocks: List<ClickClock> = listOf(
			ClickClock(1, "Click clock #1", "Description"),
			ClickClock(2, "Click clock #1", "Description"),
			ClickClock(3, "Click clock #1", "Description"),
			ClickClock(4, "Click clock #1", "Description")
		)
		return ClickClockResponse(
			clickClocks = clickClocks,
			continuationToken = clickClocks.last().id
		)
	}
}

data class ClickClock(val id: Int, val title: String, val description: String)

data class ClickClockResponse(val continuationToken: Int, val clickClocks: List<ClickClock>)
