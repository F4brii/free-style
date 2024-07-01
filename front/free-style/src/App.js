import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import BasePage from "./pages/BasePage";
import Home from "./pages/Home";
import ReservationPage from "./pages/ReservationPage";
import RatePage from "./pages/RatePage";

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<BasePage />}>
            <Route index element={<Home />} />
            <Route path="reservation" element={<ReservationPage />} />
            <Route path="rate" element={<RatePage />} />
          </Route>
          <Route path="/login" element={<LoginPage />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
