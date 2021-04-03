import React, { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import SocialButton from '../../../../common/ui/socialButton';
import VolumeOffIcon from '../../../../common/ui/icons/volumeOffIcon';
import VolumeOnIcon from '../../../../common/ui/icons/volumeOnIcon';
import PlayIcon from '../../../../common/ui/icons/playIcon';
import PauseIcon from '../../../../common/ui/icons/pauseIcon';
import './videoPlayer.css';

const VideoPlayer = ({ isCurrent, videoThumbnailUrl, videoUrl, onToggleMute, muted }) => {
  const [ videoLoaded, setVideoLoaded ] = useState(false);
  const [ isPlaying, setIsPlaying ] = useState(true);
  const videoPlayerRef = useRef();

  const handleOnCanPlay = useCallback(() => {
    setVideoLoaded(true);
  }, []);

  useEffect(
    () => {
      if (videoLoaded) {
        videoPlayerRef.current.play();
      }
    },
    [ videoLoaded ]
  );

  const videoStyle = useMemo(
    () => {
      return {
        backgroundImage: `url(${videoThumbnailUrl})`,
        backgroundSize: 'cover'
      };
    },
    [ videoThumbnailUrl ]
  );

  const onPlaying = useCallback(() => {
    setIsPlaying(true);
  }, []);
  const onPause = useCallback(() => {
    setIsPlaying(false);
  }, []);

  const togglePlay = useCallback(() => {
    if (videoPlayerRef.current) {
      if (videoPlayerRef.current.paused) {
        videoPlayerRef.current.play();
      } else {
        videoPlayerRef.current.pause();
      }
    }
  }, []);
  return (
    <div className="videoPlayer__container">
      <div className="videoPlayer__wrapper" style={videoStyle}>
        {isCurrent &&
        videoUrl && (
          <React.Fragment>
            <video
              src={videoUrl}
              ref={videoPlayerRef}
              autoPlay
              muted={muted}
              onCanPlay={handleOnCanPlay}
              onPlaying={onPlaying}
              onPause={onPause}
            />
            <div className="videoPlayer__controls">
              <div className="videoPlayer__controls--main">
                <button onClick={togglePlay}>{isPlaying ? <PauseIcon /> : <PlayIcon />}</button>
                <button onClick={onToggleMute}>{muted ? <VolumeOffIcon /> : <VolumeOnIcon />}</button>
              </div>
            </div>
          </React.Fragment>
        )}
      </div>
      <div className="videoPlayerSocial__wrapper">
        <SocialButton type="like" count={255} />
        <SocialButton type="comment" count={75} />
        <SocialButton type="share" count={35} />
      </div>
    </div>
  );
};

export default VideoPlayer;
