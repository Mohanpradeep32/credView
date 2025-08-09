

document.addEventListener("DOMContentLoaded", function () {
    const username = localStorage.getItem("username");
    const userSection = document.getElementById("userSection");

    if (username) {
        userSection.innerHTML = `
            <div class="user-dropdown">
                <div class="user-name">  ${username} ▼</div>
                <div class="dropdown-content">
                    <button onclick="logout()">Logout</button>
                </div>
            </div>
        `;
    }
});

function logout() {
    localStorage.removeItem("username");
    window.location.href = "/";
}

function goToLogin() {
    window.location.href = "/auth/login";
}

function goToRegister() {
    window.location.href = "/auth/register";
}



document.getElementById("loanTypes").addEventListener("click", function() {
    window.location.href = "/loanTypes";
});

document.getElementById("banks").addEventListener("click", function() {
    window.location.href = "/banks";
});

document.getElementById("calculateSchedule").addEventListener("click", function() {
    window.location.href = "/calculateSchedule";
});