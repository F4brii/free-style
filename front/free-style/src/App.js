import {
  Route,
  BrowserRouter as Router,
  Routes,
  Navigate,
  Outlet,
} from "react-router-dom";
import BasePage from "./pages/BasePage";
import Detalles from "./pages/Detalles";
import Home from "./pages/Home";
import LoginPage from "./pages/LoginPage";
import Precios from "./pages/Precios";
import ReservationPage from "./pages/ReservationPage";
import Signin from "./pages/Signin";
import { AuthContext, AuthProvider } from "./context/AuthContext";
import { useContext } from "react";

const PrivateRoute = ({ children }) => {
  const { isAuthenticated } = useContext(AuthContext);

  return isAuthenticated ? children : <Navigate to="/login" replace />;
};

const App = () => {
  return (
    <Router>
      <AuthProvider>
        <div className="App">
          <Routes>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/" element={<BasePage />}>
              <Route index element={<Home />} />
              <Route
                path="reservation"
                element={
                  <PrivateRoute>
                    <ReservationPage />
                  </PrivateRoute>
                }
              />
              <Route
                path="precios"
                element={
                  <PrivateRoute>
                    <Precios />
                  </PrivateRoute>
                }
              />
            </Route>
            <Route path="/signin" element={<Signin />} />
            <Route path="detalles" element={<Detalles />} />
          </Routes>
        </div>
      </AuthProvider>
    </Router>
  );
};

export default App;
