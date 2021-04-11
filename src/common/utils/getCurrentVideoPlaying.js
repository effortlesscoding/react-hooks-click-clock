function getCurrentVideoPlaying(videos, videoLayouts, scrollTopPosition) {
  let currentVideoId = null;
  let heightPassed = 0;
  console.log('videoLayouts::', videoLayouts);
  videos.some((video, index) => {
    const layout = videoLayouts[video.videoId];
    if (!layout) {
      console.log('video.videoId:: does not exist::', video.videoId);
      return false;
    }
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
