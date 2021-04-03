import { useLayoutEffect, useRef } from 'react';
import SoundIcon from '../../../common/ui/icons/soundIcon';
import VideoPlayer from './videoPlayer';
import './videoCard.css';

const VideoCard = ({
  isSkeleton,
  videoUrl,
  videoId,
  videoThumbnail,
  userAvatarUrl,
  userDisplayName,
  userId,
  description,
  tags,
  sound
}) => {
  const linkAvatar = useRef();
  const linkUserIdPrimary = useRef();
  const linkUserIdSecondary = useRef();
  const userHref = `http://google/com?search=${userId}`;

  /**
	 * Binding stuff using Vanilla JS
	 * Maybe just for the sake of demonstrating useRef.
	*/
  useLayoutEffect(() => {
    const allAnchors = [ linkAvatar.current, linkUserIdPrimary.current, linkUserIdSecondary.current ];
    function onMouseOver(e) {
      linkUserIdPrimary.current.style.textDecoration = 'underline';
    }
    function onMouseLeave(e) {
      linkUserIdPrimary.current.style.textDecoration = 'none';
    }

    if (allAnchors.every((anchor) => !!anchor)) {
      allAnchors.forEach((anchor) => {
        anchor.addEventListener('mouseover', onMouseOver);
        anchor.addEventListener('mouseleave', onMouseLeave);
      });
    }
  }, []);
  return (
    <div className={`videoCard__container ${isSkeleton ? 'skeleton' : ''}`}>
      <a ref={linkAvatar} title={`Open ${userId} link`} className="videoCardTop__avatar" href={userHref}>
        <img src={userAvatarUrl} alt="" />
      </a>
      <div className={`videoCardDetails__container`}>
        <div className={`videoCardTop__container`}>
          <div className="videoCardTop__user">
            <div className="videoCardTop__userDetails">
              <a ref={linkUserIdPrimary} href={userHref} className="videoCardTop__userId">
                <h3>{userId}</h3>
              </a>
              <a ref={linkUserIdSecondary} href={userHref} className="videoCardTop__userDisplayName">
                {userDisplayName}
              </a>
            </div>
            <div className="videoCardTop__description">
              <span>{description}</span>
              {(tags || []).map((tag) => (
                <a key={tag} className="videoCardTop__description-tag" href={`http://google.com?search=${tag}`}>
                  #{tag}
                </a>
              ))}
            </div>
          </div>
          <div className="videoCardTop__actions">
            {!isSkeleton && <button className="clickClock__button-flat">Follow</button>}
          </div>
        </div>
        {sound && (
          <div className="videoCardSound__container">
            <a href={`http://google.com?search=${sound.id}`}>
              <SoundIcon />
              <span>{sound.displayName}</span>
            </a>
          </div>
        )}
        {!isSkeleton && <VideoPlayer videoUrl={videoUrl} videoThumbnailUrl={videoThumbnail} />}
      </div>
    </div>
  );
};

export default VideoCard;
