import './App.css';
import { VideoLinksContextProvider } from './common/stores/videoLinksStore';
import VideosFeed from './ui/videosFeed';

function App() {
  return (
    <VideoLinksContextProvider>
      <VideosFeed />
    </VideoLinksContextProvider>
  )
}

export default App;
