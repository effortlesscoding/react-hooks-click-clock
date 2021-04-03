import { useMemo, createContext, useCallback, useContext, useEffect, useState } from 'react';
import { ApiState } from '../types/api';
import { request } from '../utils/http';

export const VideoLinksContext = createContext({
	state: {
		apiState: ApiState.INITIAL,
		videos: [],
		continuationToken: null,
	},
	actions: {
		loadVideos: () => {},
	},
});

export const VideoLinksContextProvider = ({ children }) => {
	/** API State */
	const [apiState, setApiState] = useState(ApiState.INITIAL);
	const [videos, setVideos] = useState([]);
	const [lastError, setLastError] = useState(null);
	const [continuationToken, setContinuationToken] = useState(null);

	const state = useMemo(() => ({
		apiState,
		videos,
		continuationToken,
		lastError,
	}), [
		apiState,
		videos,
		continuationToken,
		lastError,
	]);

	useEffect(() => {
		console.log('state::', state);
	}, [state]);

	const addVideos = useCallback((newVideos, continuationToken) => {
		const updatedVideos = [...videos, ...newVideos];
		setVideos(updatedVideos);
		setContinuationToken(continuationToken);
	}, [videos, setVideos, setContinuationToken]);

	const loadVideos = useCallback(() => {
		setApiState(ApiState.LOADING);
		request.get('/click-clocks').then((response) => {
			addVideos(response.clickClocks, response.continuationToken);
			setApiState(ApiState.SUCCESS);
			setLastError(null);
		}).catch((error) => {
			setApiState(ApiState.ERROR);
			setLastError(error);
		});
	}, [addVideos]);

	const actions = {
		loadVideos,
	};

	return (
		<VideoLinksContext.Provider value={{ state, actions }}>
			{children}
		</VideoLinksContext.Provider>
	);
};

export const useVideoLinksStore = () => {
	const { state, actions } = useContext(VideoLinksContext);
	return {
		actions,
		state,
	};
};
