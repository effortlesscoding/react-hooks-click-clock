import CommentIcon from './icons/commentIcon';
import ShareIcon from './icons/shareIcon';
import HeartIcon from './icons/heartIcon';
import './socialButton.css';

const SocialButton = ({ type, count }) => {
  return (
    <span className="socialButtonWrapper">
      <button className="socialButtonIcon">
        {(() => {
          switch (type) {
            case 'comment':
              return <CommentIcon />;
            case 'like':
              return <HeartIcon />;
            case 'share':
              return <ShareIcon />;
            default:
              return null;
          }
        })()}
      </button>
      <span>{count}</span>
    </span>
  );
};

export default SocialButton;
