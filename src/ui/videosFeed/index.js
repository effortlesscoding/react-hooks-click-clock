import { useVideoLinksStore } from '../../common/stores/videoLinksStore';
import { useVideoLinksUIStore } from '../../common/stores/videoLinksUiStore';
import ScrollWaypoint from '../../common/ui/scrollWaypoint';
import React, { useCallback, useEffect, useLayoutEffect, useRef } from 'react';
import { ApiState } from '../../common/types/api';
import VideoCard from './videoCard';
import Header from './header';
import Sidebar from './sidebar';
import './videosFeed.css';

const skeletonImageUrl =
  'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mN8Xw8AAmMBcHOnfc4AAAAASUVORK5CYII=';

function VideosFeed() {
  const mainContainerRef = useRef();
  const { actions: uiActions } = useVideoLinksUIStore();
  const { actions, state } = useVideoLinksStore();
  const loadVideosFn = actions.loadVideos;
  const { onScrollContainer } = uiActions;
  const { apiState, canLoadMore } = state;
  useLayoutEffect(() => {
    loadVideosFn();
  }, []);

  const initialRecalculationDone = useRef(false);
  useEffect(
    () => {
      if (!initialRecalculationDone.current && apiState === ApiState.SUCCESS) {
        initialRecalculationDone.current = true;
        onScrollContainer(mainContainerRef.current);
      }
    },
    [ apiState, onScrollContainer ]
  );

  const onScroll = useCallback(
    (e) => {
      onScrollContainer(e.target);
    },
    [ onScrollContainer ]
  );
  const handleOnEnterWaypoint = useCallback(
    (e) => {
      if (apiState === ApiState.SUCCESS && canLoadMore) {
        loadVideosFn();
      }
    },
    [ loadVideosFn, canLoadMore, apiState ]
  );
  return (
    <div className="videosFeedScrollArea" ref={mainContainerRef} onScroll={onScroll}>
      <div className="videosFeed__scrollableArea">
        <header className="videosFeed__header">
          <Header />
        </header>
        <div className="videosFeed__sidebar">
          <Sidebar />
        </div>
        <main className="videosFeed__container">
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
          {apiState === ApiState.LOADING && (
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
          )}
        </main>
      </div>
      <ScrollWaypoint onEnter={handleOnEnterWaypoint} />
    </div>
  );
}

export default VideosFeed;
