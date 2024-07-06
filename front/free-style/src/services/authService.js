export const login = async (email, password) => {
  if (email === "admin@example.com" && password === "admin") {
    return { success: true };    
  } else {
    return { success: false };
  }
};
