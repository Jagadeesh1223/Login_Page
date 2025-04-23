/* App.jsx */
import React, { useState } from "react";
import Login from "./Login";
import Dashboard from "./Dashboard";

function App() {
  const [user, setUser] = useState(null);

  return (
    <div>
      {user ? <Dashboard username={user} /> : <Login setUser={setUser} />}
    </div>
  );
}
export default App;