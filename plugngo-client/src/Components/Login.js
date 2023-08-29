import React, { useState } from "react";
import axios from "axios";
import "./Login.css";

export const Login = () => {
  const [usernam, setUsername] = useState("");
  const [pass, setPass] = useState("");
  const [userLog, setUserLog] = useState({
    username: "",
    password: ""
  })

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(usernam);
  };

  const instance = axios.create({
    baseURL: 'http://localhost:9090',
    headers: { "skip-browser-warning": "true" }
  })

  const submitLogin = () => {
    setUserLog({
      password: pass,
      username: usernam,
    })
    instance.post("api/auth/signin", userLog)
      .then((response) => {
        console.log('Registration successful:', response.data);
      })
      .catch(error => {
        console.error('Registration failed:', error.response.data);
      })
  }

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
        <button type="submit" onClick={submitLogin}>Log In</button>
      </form>
    </div>
  );
};
