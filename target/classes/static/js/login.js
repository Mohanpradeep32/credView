document.getElementById("loginForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const data = {
    username: document.getElementById("username").value,
    password: document.getElementById("password").value
  };

  try {
    const response = await fetch("http://localhost:8080/auth/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    const text = await response.text();
    document.getElementById("loginMessage").textContent = text;

    if (text.includes("successful")) {
      setTimeout(() => {
        window.location.href = "/"; // redirect after login success
      }, 1000);
    }
  } catch (error) {
    console.error("Login error:", error);
    document.getElementById("loginMessage").textContent = "Login failed!";
  }
});
