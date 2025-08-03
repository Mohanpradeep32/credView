document.getElementById("registerForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const data = {
    username: document.getElementById("username").value,
    password: document.getElementById("password").value,
    dateOfBirth: document.getElementById("dateOfBirth").value,
    mobileNo: document.getElementById("mobileNo").value,
    email: document.getElementById("email").value
  };

  try {
    const response = await fetch("http://localhost:8080/auth/api/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    const text = await response.text();
    document.getElementById("registerMessage").textContent = text;

    if (text.includes("Registered successfully")) {
      setTimeout(() => {
        window.location.href = "/auth/login";
      }, 1500); // Redirect to login after a short delay
    }
  } catch (error) {
    console.error("Error during registration:", error);
    document.getElementById("registerMessage").textContent = "Something went wrong.";
  }
});
