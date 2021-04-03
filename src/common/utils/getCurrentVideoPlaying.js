function getCurrentVideoPlaying(videoLayouts, scrollTopPosition) {
	let currentVideoPlayingIndex = null;
	let heightPassed = 0;
	videoLayouts.forEach((layout, index) => {
		heightPassed += layout.height;
		const halfElementHeight = layout.height / 2;
		if (heightPassed - halfElementHeight > scrollTopPosition) {
			currentVideoPlayingIndex = index;
		}
	});
	return Number.isFinite(currentVideoPlayingIndex) ? videoLayouts[currentVideoPlayingIndex] : null;
};

export default getCurrentVideoPlaying;
