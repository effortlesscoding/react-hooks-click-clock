import { useMemo } from 'react';
import SocialButton from '../../../../common/ui/socialButton';
import './videoPlayer.css';

const VideoPlayer = ({ isCurrent, videoThumbnailUrl, videoUrl }) => {
  const videoStyle = useMemo(
    () => {
      if (isCurrent) {
        return {};
      }
      return {
        backgroundImage: `url(${videoThumbnailUrl})`,
        backgroundSize: 'cover'
      };
    },
    [ isCurrent, videoThumbnailUrl ]
  );

  return (
    <div className="videoPlayer__container">
      <div className="videoPlayer__wrapper" style={videoStyle} />
      {isCurrent && videoUrl && <video src={videoUrl} autoPlay />}
      <div className="videoPlayerSocial__wrapper">
        <SocialButton type="like" count={255} />
        <SocialButton type="comment" count={75} />
        <SocialButton type="share" count={35} />
      </div>
    </div>
  );
};

export default VideoPlayer;
