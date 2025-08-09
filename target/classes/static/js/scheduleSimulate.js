let maxLoanAmt = 0;

document.addEventListener("DOMContentLoaded", () => {
    fetch("/api/loan-types")
        .then(res => res.json())
        .then(data => {
            let select = document.getElementById("loanType");
            data.forEach(type => {
                let option = document.createElement("option");
                option.value = type.loanTypeName;
                option.text = type.loanTypeName;
                select.add(option);
            });
        });
});


document.getElementById("loanType").addEventListener("change", function () {
    let loanTypeName = this.value;
    if (!loanTypeName) return;

    fetch(`/api/loan-types/getByName?name=${encodeURIComponent(loanTypeName)}`)
        .then(res => res.json())
        .then(loanType => {
            document.getElementById("interestRate").value = loanType.interestRate;
            document.getElementById("interestRateValue").textContent = loanType.interestRate;
            maxLoanAmt = loanType.maxLoanAmount;
            document.getElementById("tenure").value = loanType.tenureMonths;
            document.getElementById("tenureValue").textContent = loanType.tenureMonths;
            document.getElementById("repayDay").value = loanType.repaymentDay;
        });
});


document.getElementById("loanAmount").addEventListener("input", function () {
    let val = parseFloat(this.value);
    document.getElementById("loanAmountValue").textContent = val.toLocaleString();
    let errorEl = document.getElementById("loanAmountError");
    errorEl.textContent = val > maxLoanAmt ? `Max allowed: ₹${maxLoanAmt}` : "";
});


document.getElementById("interestRate").addEventListener("input", function () {
    document.getElementById("interestRateValue").textContent = this.value;
});


document.getElementById("tenure").addEventListener("input", function () {
    document.getElementById("tenureValue").textContent = this.value;
});


document.getElementById("calculateBtn").addEventListener("click", async () => {
    const loanType = document.getElementById("loanType").value;
    const loanAmount = parseFloat(document.getElementById("loanAmount").value);
    const interestRate = parseFloat(document.getElementById("interestRate").value);
    const tenure = parseInt(document.getElementById("tenure").value);
    const repayDay = parseInt(document.getElementById("repayDay").value);

    const res = await fetch("/calculateSchedule", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ loanType, loanAmount, interestRate, tenure, repayDay })
    });

    const schedule = await res.json();
    displaySchedule(schedule);
});

function displaySchedule(schedule) {
    const tbody = document.querySelector("#scheduleTable tbody");
    tbody.innerHTML = "";
    schedule.forEach((entry, index) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${entry.dueDate}</td>
            <td>${entry.principal.toFixed(2)}</td>
            <td>${entry.interest.toFixed(2)}</td>
            <td>${entry.totalPayment.toFixed(2)}</td>
            <td>${entry.remainingBalance.toFixed(2)}</td>
        `;
        tbody.appendChild(row);
    });
    document.getElementById("resultSection").style.display = "block";
}
