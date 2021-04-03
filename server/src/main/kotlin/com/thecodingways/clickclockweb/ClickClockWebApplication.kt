package com.thecodingways.clickclockweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

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
			ClickClock(
					videoId = 1,
					videoUrl = "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4",
					videoThumbnail = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 1",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round"
			),
			ClickClock(
					videoId = 2,
					videoUrl = "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4",
					videoThumbnail = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 2",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round"
			),
			ClickClock(
					videoId = 3,
					videoUrl = "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4",
					videoThumbnail = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 3",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round"
			),
			ClickClock(
					videoId = 4,
					videoUrl = "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4",
					videoThumbnail = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 4",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round"
			)
		)
		TimeUnit.SECONDS.sleep(2L);
		return ClickClockResponse(
			clickClocks = clickClocks,
			continuationToken = clickClocks.last().videoId
		)
	}
}

data class ClickClock(
		val videoId: Int,
		val videoUrl: String,
		val videoThumbnail: String,
		val userAvatarUrl: String,
		val userId: String,
		val userDisplayName: String,
		val description: String
)

data class ClickClockResponse(val continuationToken: Int, val clickClocks: List<ClickClock>)
