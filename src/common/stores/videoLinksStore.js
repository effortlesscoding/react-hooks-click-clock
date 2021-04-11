import { useMemo, createContext, useCallback, useContext, useEffect, useState, useLayoutEffect, useRef } from 'react';
import { ApiState } from '../types/api';
import { request } from '../utils/http';

const voidFn = () => {};

export const VideoLinksContext = createContext({
  state: {
    apiState: ApiState.INITIAL,
    videos: [],
    continuationToken: null
  },
  actions: {
    loadVideos: voidFn
  }
});

export const VideoLinksContextProvider = ({ children }) => {
  /** API State */
  const [ apiState, setApiState ] = useState(ApiState.INITIAL);
  const [ videos, setVideos ] = useState([]);
  const [ lastError, setLastError ] = useState(null);
  const [ continuationToken, setContinuationToken ] = useState(null);

  const state = useMemo(
    () => ({
      apiState,
      videos,
      continuationToken,
      lastError,
      canLoadMore: continuationToken !== null || apiState === ApiState.INITIAL
    }),
    [ apiState, videos, continuationToken, lastError ]
  );

  // Just for logging purposes
  useEffect(
    () => {
      console.log('state::', state);
    },
    [ state ]
  );

  useLayoutEffect(() => {}, []);

  const addVideos = useCallback(
    (newVideos, continuationToken) => {
      const updatedVideos = [ ...videos, ...newVideos ];
      setVideos(updatedVideos);
      setContinuationToken(continuationToken);
    },
    [ videos, setVideos, setContinuationToken ]
  );

  const loadVideos = useCallback(
    () => {
      setApiState(ApiState.LOADING);
      const after = videos[videos.length - 1] ? videos[videos.length - 1].videoId : null;
      request
        .get('/click-clocks' + (Number.isFinite(after) ? `?after=${after}` : ''))
        .then((response) => {
          addVideos(response.clickClocks, response.continuationToken);
          setApiState(ApiState.SUCCESS);
          setLastError(null);
        })
        .catch((error) => {
          setApiState(ApiState.ERROR);
          setLastError(error);
        });
    },
    [ addVideos, videos ]
  );

  const actions = useMemo(() => ({ loadVideos }), [ loadVideos ]);

  return <VideoLinksContext.Provider value={{ state, actions }}>{children}</VideoLinksContext.Provider>;
};

export const useVideoLinksStore = () => {
  const { state, actions } = useContext(VideoLinksContext);
  return {
    actions,
    state
  };
};
