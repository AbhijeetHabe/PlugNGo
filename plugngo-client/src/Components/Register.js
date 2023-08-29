import React, { useState } from "react";
import "./Register.css";
import axios from "axios";

export const Register = (props) => {
  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const [name, setName] = useState("");
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: "",
    role: []
  })

  const instance = axios.create({
    baseURL: 'http://localhost:9090',
    headers: { "skip-browser-warning": "true" }
  })

  const submitRegister = () => {
    setUser({
      username: name,
      password: pass,
      email: email,
      role: [selectedRole]
    })
    instance.post("api/auth/signup", user)
      .then(response => {
        console.log('Registration successful:', response.data);
      })
      .catch(error => {
        console.error('Registration failed:', error.response.data);
      })
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(email);
  };
  const [selectedRole, setSelectedRole] = useState("user");

  const handleRoleChange = (event) => {
    setSelectedRole(event.target.value);
  };

  return (
    <div className="auth-form-container">
      <ur>
        <h2>Register</h2>
      </ur>
      <form className="register-form" onSubmit={handleSubmit}>
        <label htmlFor="name">Full name</label>

        <input
          value={name}
          name="name"
          onChange={(e) => setName(e.target.value)}
          id="name"
          placeholder="full Name"
        />
        <label htmlFor="email">email</label>
        <input
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          type="email"
          placeholder="youremail@gmail.com"
          id="email"
          name="email"
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
        <div>
          <h2>Select Role:</h2>
          <select value={selectedRole} onChange={handleRoleChange}>
            <option value="user">User</option>
            <option value="admin">Admin</option>
          </select>
          {selectedRole === "user" && <p>Register as User!</p>}
          {selectedRole === "admin" && <p>Register as Admin!</p>}
        </div>
        <button type="submit" onClick={submitRegister}>Register</button>
      </form>
    </div>
  );
};
