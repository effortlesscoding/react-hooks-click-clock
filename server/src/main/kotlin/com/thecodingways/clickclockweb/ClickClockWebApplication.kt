package com.thecodingways.clickclockweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@SpringBootApplication
class ClickClockWebApplication

fun main(args: Array<String>) {
	runApplication<ClickClockWebApplication>(*args)
}

@RestController
class ClickClockResource {
	val PAGE_SIZE = 5
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
			),
			ClickClock(
					videoId = 5,
					videoUrl="https://player.vimeo.com/external/477575707.sd.mp4?s=939eb27c0ecdd9a27f1bedbb050b935267779a6b&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5850465/african-american-afro-hair-apparel-arid-5850465.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 5",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 6,
					videoUrl="https://player.vimeo.com/external/475811508.sd.mp4?s=daebf8a7f5eb3c0cd282323e6111f855505c32a7&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5798910/care-cough-health-care-ilness-5798910.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 6",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 7,
					videoUrl="https://player.vimeo.com/external/475034508.sd.mp4?s=9d0be3a68dc0ccfdea27d254e7ec558829d60f24&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5780797/pexels-photo-5780797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 7",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 8,
					videoUrl="https://player.vimeo.com/external/460745600.sd.mp4?s=afd95ae3b850b88f45615819374c491bf9a1eb82&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5422502/halloween-pumpkin-5422502.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 8",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 9,
					videoUrl="https://player.vimeo.com/external/353569579.sd.mp4?s=3f59b9d76e06eec3fa76a327b90774abf0919311&profile_id=139&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/2796076/free-video-2796076.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 9",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			),
			ClickClock(
					videoId = 10,
					videoUrl="https://player.vimeo.com/external/476686717.sd.mp4?s=adf15e08a34d363be44d022259c38659f659db1e&profile_id=165&oauth2_token_id=57447761",
					videoThumbnail = "https://images.pexels.com/videos/5820800/background-videos-blue-neon-free-video-download-hello-5820800.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
					userAvatarUrl = "https://i.guim.co.uk/img/media/8a13052d4db7dcd508af948e5db7b04598e03190/0_294_5616_3370/master/5616.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=bcaa4eed2c1e6dab61c41a61e41433d9",
					userId = "ABCUser 10",
					userDisplayName = "Rosetta Johnson",
					description = "I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round I found that Earth is round",
					tags = listOf("cats", "animals"),
					sound = CCSound(displayName = "Nice sound", id="sound")
			)
	)
	@GetMapping(path = ["/click-clocks"])
	fun index(@RequestParam(name="after", required = false) after: Integer?): ClickClockResponse {
		var responseClickClocks: List<ClickClock> = if (after != null) {
			clickClocks.filter{ cc -> cc.videoId > after.toInt() }.take(PAGE_SIZE)
		} else {
			clickClocks.take(5)
		}
		TimeUnit.SECONDS.sleep(2L);
		return ClickClockResponse(
			clickClocks = responseClickClocks,
			continuationToken = if (responseClickClocks.size < PAGE_SIZE) {
				null
			} else {
				responseClickClocks.last().videoId
			}
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

data class ClickClockResponse(val continuationToken: Int?, val clickClocks: List<ClickClock>)
