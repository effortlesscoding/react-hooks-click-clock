import { useRef, createContext, useCallback, useContext, useState } from 'react';
import getCurrentVideoPlaying from '../utils/getCurrentVideoPlaying';
import { useVideoLinksStore } from './videoLinksStore';

const voidFn = () => {};

export const VideoLinksUIContext = createContext({
  state: {},
  refs: {
    onScrollContainer: voidFn,
    subscribeVideoCard: voidFn,
    unsubscribeVideoCard: voidFn
  }
});

export const VideoLinksUIContextProvider = ({ children }) => {
  const [ currentPlayingVideoId, setCurrentPlayingVideoId ] = useState(null);
  const [ muted, setMuted ] = useState(true);
  /** UI state */
  const videoCardReferences = useRef({});

  const state = { currentPlayingVideoId, muted };
  const actions = { setCurrentPlayingVideoId, setMuted };
  return (
    <VideoLinksUIContext.Provider value={{ state, actions, refs: { videoCardReferences } }}>
      {children}
    </VideoLinksUIContext.Provider>
  );
};

export const useVideoLinksUIStore = () => {
  const { state: apiState } = useVideoLinksStore();
  const { state: contextState, actions: contextActions, refs } = useContext(VideoLinksUIContext);

  const { videoCardReferences } = refs;

  const onScrollContainer = useCallback(
    (e) => {
      const currentVideoId = getCurrentVideoPlaying(apiState.videos, videoCardReferences.current, e.scrollTop);
      contextActions.setCurrentPlayingVideoId(currentVideoId);
    },
    [ apiState.videos, contextActions, videoCardReferences ]
  );

  const subscribeVideoCard = useCallback(
    (videoId, element) => {
      videoCardReferences.current[videoId] = {
        videoId,
        height: element.clientHeight,
        element
      };
    },
    [ videoCardReferences ]
  );

  const unsubscribeVideoCard = useCallback(
    (videoId) => {
      videoCardReferences.current[videoId] = null;
    },
    [ videoCardReferences ]
  );

  const onToggleMute = () => {
    contextActions.setMuted(!contextState.muted);
  };

  const actions = {
    subscribeVideoCard,
    unsubscribeVideoCard,
    onScrollContainer,
    onToggleMute
  };

  return {
    actions,
    state: contextState
  };
};
