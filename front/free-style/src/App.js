import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import BasePage from "./pages/BasePage";
import Home from "./pages/Home";
import LoginPage from "./pages/LoginPage";
import Precios from "./pages/Precios";
import ReservationPage from "./pages/ReservationPage";

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<BasePage />}>
            <Route index element={<Home />} />
            <Route path="reservation" element={<ReservationPage />} />
            <Route path="precios" element={<Precios />} />
          </Route>
          <Route path="/login" element={<LoginPage />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
