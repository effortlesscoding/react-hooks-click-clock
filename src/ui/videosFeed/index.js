import { useVideoLinksStore } from '../../common/stores/videoLinksStore';
import { useEffect } from 'react';
import { ApiState } from '../../common/types/api';
import VideoCard from './videoCard';
import './videosFeed.css';

const skeletonImageUrl =
  'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mN8Xw8AAmMBcHOnfc4AAAAASUVORK5CYII=';

function VideosFeed() {
  const { state, actions } = useVideoLinksStore();
  const loadVideosFn = actions.loadVideos;

  useEffect(() => {
    loadVideosFn();
  }, []);

  return (
    <div className="App">
      <button onClick={loadVideosFn}>Force fetch more</button>
      {(() => {
        switch (state.apiState) {
          case ApiState.INITIAL:
            return null;
          case ApiState.LOADING:
            return (
              <div className="videosFeed__container">
                <VideoCard
                  isSkeleton
                  key="1"
                  videoUrl=""
                  videoId="1"
                  videoThumbnail="http://nowhere.com"
                  userAvatarUrl={skeletonImageUrl}
                  userDisplayName="__________"
                  userId="______"
                  description="____________________________________"
                />
              </div>
            );
          case ApiState.SUCCESS:
            return (
              <div className="videosFeed__container">
                {state.videos.map((data) => (
                  <VideoCard
                    key={data.userId}
                    videoUrl={data.videoUrl}
                    videoId={data.videoId}
                    videoThumbnail={data.videoThumbnail}
                    userAvatarUrl={data.userAvatarUrl}
                    userDisplayName={data.userDisplayName}
                    userId={data.userId}
                    description={data.description}
                    tags={data.tags}
                    sound={data.sound}
                  />
                ))}
              </div>
            );
          default:
            return null;
        }
      })()}
    </div>
  );
}

export default VideosFeed;
