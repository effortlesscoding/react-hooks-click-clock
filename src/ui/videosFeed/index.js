import { useVideoLinksStore } from '../../common/stores/videoLinksStore';
import { useEffect } from 'react';
import { ApiState } from '../../common/types/api';

function VideosFeed() {
  const { state, actions } = useVideoLinksStore();
  const loanVideosFn = actions.loadVideos;

  useEffect(() => {
    loanVideosFn();
  }, []);

  return (
    <div className="App">
      {(() => {
        switch (state.apiState) {
          case ApiState.INITIAL:
            return null;
          case ApiState.LOADING:
            return <p>Loading</p>;

          case ApiState.SUCCESS:
            return <p>Videos loaded : {JSON.stringify(state.videos)}</p>;
          default:
            return null;
        }
      })()}
    </div>
  );
}

export default VideosFeed;
