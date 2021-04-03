function getCurrentVideoPlaying(videos, videoLayouts, scrollTopPosition) {
  let currentVideoId = null;
  let heightPassed = 0;
  videos.some((video, index) => {
    const layout = videoLayouts[video.videoId];
    heightPassed += layout.height;
    const halfElementHeight = layout.height / 2;
    if (heightPassed - halfElementHeight > scrollTopPosition) {
      currentVideoId = video.videoId;
      return true;
    }
    return false;
  });
  return Number.isFinite(currentVideoId) ? videoLayouts[currentVideoId] : null;
}

export default getCurrentVideoPlaying;
