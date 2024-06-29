export const login = async (email, password) => {
  if (email === "test@example.com" && password === "password") {
    return { success: true, token: "fake-jwt-token" };
  } else {
    throw new Error("Invalid email or password");
  }
};
