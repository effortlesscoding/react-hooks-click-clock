import './App.css';
import { VideoLinksContextProvider } from './common/stores/videoLinksStore';
import { VideoLinksUIContextProvider } from './common/stores/videoLinksUiStore';
import VideosFeed from './ui/videosFeed';

function App() {
  return (
    <VideoLinksContextProvider>
      <VideoLinksUIContextProvider>
        <VideosFeed />
      </VideoLinksUIContextProvider>
    </VideoLinksContextProvider>
  );
}

export default App;
