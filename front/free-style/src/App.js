import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/LoginPage";

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          {/* Agrega otras rutas aquí */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;
