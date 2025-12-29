<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>OTP Verification</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Tailwind CDN -->
  <script src="https://cdn.tailwindcss.com"></script>

  <style>
    .otp-input {
      width: 3.5rem;
      height: 3.5rem;
      text-align: center;
      font-size: 1.5rem;
      font-weight: bold;
      border: 2px solid #d1d5db;
      border-radius: 0.75rem;
      outline: none;
    }

    .otp-input:focus {
      border-color: #16a34a;
      box-shadow: 0 0 0 2px rgba(22, 163, 74, 0.4);
    }
  </style>
</head>

<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<div class="bg-white w-full max-w-md p-8 rounded-xl shadow-lg">

  <!-- Title -->
  <h2 class="text-2xl font-bold text-gray-800 text-center mb-2">
    OTP Verification
  </h2>
  <p class="text-gray-500 text-center mb-6">
    Enter the 4-digit OTP sent to your email
  </p>

  <!-- OTP FORM -->
  <form action="verify" method="post" class="space-y-6">

    <!-- OTP INPUT BOXES -->
    <div class="flex justify-center gap-4">
      <input type="text" maxlength="1" inputmode="numeric" class="otp-input" />
      <input type="text" maxlength="1" inputmode="numeric" class="otp-input" />
      <input type="text" maxlength="1" inputmode="numeric" class="otp-input" />
      <input type="text" maxlength="1" inputmode="numeric" class="otp-input" />
    </div>

    <!-- Hidden Combined OTP -->
    <input type="hidden" name="otp" id="otp">

    <!-- Timer -->
    <p class="text-sm text-gray-500 text-center">
      OTP expires in
      <span id="timer" class="font-semibold text-green-600">02:00</span>
    </p>

    <!-- Submit Button -->
    <button
      class="w-full bg-green-600 text-white py-2 rounded-md
             hover:bg-green-700 transition font-medium">
      Verify OTP
    </button>
  </form>

  <!-- Resend -->
  <div class="text-center mt-4">
    <button id="resendBtn" disabled
      onclick="resendOtp()"
      class="text-sm text-gray-400 cursor-not-allowed">
      Resend OTP
    </button>
  </div>

</div>

<!-- JavaScript -->
<script>
const inputs = document.querySelectorAll(".otp-input");
const otpHidden = document.getElementById("otp");

/* Auto move & backspace */
inputs.forEach((input, index) => {

  input.addEventListener("input", () => {
    input.value = input.value.replace(/[^0-9]/g, "");

    if (input.value && index < inputs.length - 1) {
      inputs[index + 1].focus();
    }
    combineOtp();
  });

  input.addEventListener("keydown", (e) => {
    if (e.key === "Backspace" && !input.value && index > 0) {
      inputs[index - 1].focus();
    }
  });
});

/* Combine OTP */
function combineOtp() {
  let otp = "";
  inputs.forEach(input => otp += input.value);
  otpHidden.value = otp;
}

/* Timer */
let time = 120;
const timer = document.getElementById("timer");
const resendBtn = document.getElementById("resendBtn");

const interval = setInterval(() => {
  let min = Math.floor(time / 60);
  let sec = time % 60;
  timer.textContent = `${min}:${sec < 10 ? '0' + sec : sec}`;

  if (--time < 0) {
    clearInterval(interval);
    resendBtn.disabled = false;
    resendBtn.className =
      "text-sm text-green-600 hover:underline cursor-pointer";
  }
}, 1000);

/* Resend OTP */
function resendOtp() {
  window.location.href = "resendOtp";
}
</script>

</body>
</html>
