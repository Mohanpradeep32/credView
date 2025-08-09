document.getElementById("loginForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  const data = { username, password };

  try {
    const response = await fetch("/auth/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    const text = await response.text();
    document.getElementById("loginMsg").textContent = text; 

    if (text.includes("Login successful")) {
      localStorage.setItem("username", username);
      setTimeout(() => {
        window.location.href = "/";
      }, 1000);
    }
  } catch (error) {
    console.error("Error during login:", error);
    document.getElementById("loginMsg").textContent = "Something went wrong.";
  }
});
