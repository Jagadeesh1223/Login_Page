// Dashboard.jsx
import React from "react";
import "./assets/styles.css";

function Dashboard({ username }) {
  return (
    <div className="dashboard-container">
      <h1>Hello {username},</h1>
      <h2>Welcome to KodNest Dashboard!</h2>
    </div>
  );
}

export default Dashboard;