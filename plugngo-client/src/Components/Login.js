import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Login.css";

export const Login = () => {
  const [usernam, setUsername] = useState("");
  const [pass, setPass] = useState("");

  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    submitLogin();
  };

  const instance = axios.create({
    baseURL: 'http://localhost:9090',
    headers: { "skip-browser-warning": "true" }
  });

  const submitLogin = () => {
    const userLog = {
      username: usernam,
      password: pass,
    };

    instance.post("api/auth/signin", userLog)
      .then((response) => {
        console.log("Response Data:", response.data);

        // Check if response.data is defined and contains the role property
        if (response.data && response.data.roles) {
          if (response.data.roles.includes("ROLE_ADMIN")) {
            sessionStorage.setItem("admin", JSON.stringify(response.data));
            navigate(`/admin`);
          } else if (response.data.roles.includes("ROLE_USER")) {
            sessionStorage.setItem("user", JSON.stringify(response.data));
            navigate(`/admin`);
          }
        } else {
          console.error("Login Error: Invalid response data format");
        }
      })
      .catch((error) => {
        console.error("Login Error:", error);
      });
  };


  return (
    <div className="auth-form-container">
      <h2>Login</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <label htmlFor="username">username</label>
        <input
          value={usernam}
          onChange={(e) => setUsername(e.target.value)}
          type="username"
          placeholder="youremail@gmail.com"
          id="username"
          name="username"
        />
        <label htmlFor="password">password</label>
        <input
          value={pass}
          onChange={(e) => setPass(e.target.value)}
          type="password"
          placeholder="********"
          id="password"
          name="password"
        />
        <button type="submit">Log In</button>
      </form>
    </div>
  );
};
