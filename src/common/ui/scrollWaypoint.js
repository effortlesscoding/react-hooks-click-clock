import { useLayoutEffect, useRef } from 'react';

const ScrollWaypoint = ({ onEnter }) => {
  const scrollWaypointRef = useRef();
  const entered = useRef();
  useLayoutEffect(
    () => {
      const parent = scrollWaypointRef.current.parentElement;
      function onScroll(e) {
        e.stopPropagation();
        const viewportHeight = window.innerHeight;
        const waypointPosY = e.currentTarget.scrollTop + scrollWaypointRef.current.getBoundingClientRect().top;
        const containerScrollY = viewportHeight + e.currentTarget.scrollTop;
        if (containerScrollY > waypointPosY - 50) {
          if (!entered.current) {
            entered.current = true;
            onEnter();
          }
        } else {
          entered.current = false;
        }
      }
      parent.addEventListener('scroll', onScroll);
      return () => {
        parent.removeEventListener('scroll', onScroll);
      };
    },
    [ onEnter, scrollWaypointRef ]
  );
  return <div ref={scrollWaypointRef} />;
};

export default ScrollWaypoint;
