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
					videoId = 0,
					videoUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
					videoThumbnail = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8I53CNAbGzZeFSU4YSWd2QxIh-E-IB8flW8tp_1hDi0d5tfEAiVesvTXJ5HqiWxseh5Q&usqp=CAU",
					userAvatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8I53CNAbGzZeFSU4YSWd2QxIh-E-IB8flW8tp_1hDi0d5tfEAiVesvTXJ5HqiWxseh5Q&usqp=CAU",
					userId = "ABCUser 0",
					userDisplayName = "Rabbit Rabbinson",
					description = "I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 1,
					videoUrl = "https://player.vimeo.com/external/530033109.sd.mp4?s=88bb93dc6805165e7c2606fbb4b0dee2eb0e305a&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://i.vimeocdn.com/video/1097058535.webp?mw=1200&mh=2133",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 1",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 2,
					videoUrl = "https://player.vimeo.com/external/475042397.sd.mp4?s=7276497e9377cad1382316b84ad5c609741efcd9&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5780959/pexels-photo-5780959.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 2",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 3,
					videoUrl = "https://player.vimeo.com/external/530032982.sd.mp4?s=5c27e896759b088de517b822f5b89ecd560c7539&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/7293683/adult-adventure-aloha-beach-7293683.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 3",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 4,
					videoUrl = "https://player.vimeo.com/external/472307014.sd.mp4?s=9273ee123d69d2e7f521d6b7f72041a7077ad46a&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5703798/pexels-photo-5703798.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 4",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			)
		)
		TimeUnit.SECONDS.sleep(2L);
		return ClickClockResponse(
			clickClocks = clickClocks,
			continuationToken = clickClocks.last().videoId
		)
	}
}

data class CCSound(
	val displayName: String,
	val id: String
)

data class ClickClock(
		val videoId: Int,
		val videoUrl: String,
		val videoThumbnail: String,
		val userAvatarUrl: String,
		val userId: String,
		val userDisplayName: String,
		val description: String,
		val tags: List<String>,
		val sound: CCSound
)

data class ClickClockResponse(val continuationToken: Int, val clickClocks: List<ClickClock>)
