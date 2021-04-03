import Logo from './logo.gif';
import './header.css';

const Header = () => (
  <div className="header">
    <img src={Logo} alt="Click clock logo" />
    <div>
      <h1>Click Clock</h1>
    </div>
  </div>
);

export default Header;
