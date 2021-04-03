import { useVideoLinksStore } from '../../common/stores/videoLinksStore';
import { useEffect } from 'react';
import { ApiState } from '../../common/types/api';
import VideoCard from './videoCard';
import './videosFeed.css';

function VideosFeed() {
  const { state, actions } = useVideoLinksStore();
  const loadVideosFn = actions.loadVideos;

  useEffect(() => {
    loadVideosFn();
  }, []);

  return (
    <div className="App">
      <button onClick={loadVideosFn}>Re-load</button>
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
                  userAvatarUrl=""
                  userDisplayName="______"
                  userId="______"
                  description="_________"
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
