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
    const response = await fetch("/auth/api/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    const text = await response.text();
    document.getElementById("registerMsg").textContent = text;

    if (text.includes("Registered successfully")) {
      setTimeout(() => {
        window.location.href = "/auth/login";
      }, 500); 
    }
  } catch (error) {
    console.error("Error during registration:", error);
    document.getElementById("registerMsg").textContent = "Something went wrong.";
  }
});
