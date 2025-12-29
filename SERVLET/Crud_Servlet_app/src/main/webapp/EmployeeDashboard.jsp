<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    HttpSession s = request.getSession(false);

    if (s == null || s.getAttribute("empid") == null) {
        response.sendRedirect("login.html");
        return;
    }

    String empid = String.valueOf(s.getAttribute("empid"));
    String empname = s.getAttribute("empname") != null
            ? s.getAttribute("empname").toString()
            : "Teaching Associate";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 min-h-screen">

<!-- ================= NAVBAR ================= -->
<header class="bg-white shadow-sm">
    <div class="max-w-7xl mx-auto px-6 py-4 flex justify-between items-center">

        <!-- Logo -->
        <h1 class="text-2xl font-bold text-green-600">EMS</h1>

        <!-- Profile Area -->
        <div class="relative flex items-center gap-2 cursor-pointer"
             onclick="toggleMenu()">

            <!-- Avatar -->
            <div class="w-10 h-10 rounded-full border-2 border-green-600
                        flex items-center justify-center hover:bg-green-50 transition">
                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
                     class="w-6 h-6" alt="Profile">
            </div>

            <!-- Name -->
            <span class="text-sm font-medium text-gray-700 hidden sm:block">
                <%= empname %>
            </span>

            <!-- DROPDOWN MENU -->
            <div id="profileMenu"
                 class="hidden absolute right-0 top-12 w-56
                        bg-white rounded-lg shadow-lg border z-50">

                <!-- Header -->
                <div class="px-4 py-3 border-b">
                    <p class="text-sm font-semibold text-gray-800">
                        <%= empname %>
                    </p>
                    <p class="text-xs text-gray-500 mb-2">
                        Teaching Associate
                    </p>

                    <!-- 🔐 SECURED ACCOUNT BADGE -->
                    <div class="flex items-center gap-2 bg-green-50
                                border border-green-600 rounded-md px-2 py-1 w-fit">
                        <!-- Lock Icon -->
                        <svg xmlns="http://www.w3.org/2000/svg"
                             class="h-4 w-4 text-green-600"
                             fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2"
                                  d="M12 11c1.657 0 3 1.343 3 3v4H9v-4c0-1.657 1.343-3 3-3z"/>
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2"
                                  d="M8 11V7a4 4 0 118 0v4"/>
                        </svg>

                        <span class="text-xs font-medium text-green-700">
                            Secured Account
                        </span>
                    </div>
                </div>

                <!-- Actions -->
                <a href="editProfile.jsp"
                   class="block px-4 py-2 text-sm text-gray-700 hover:bg-green-50">
                    ✏️ Edit Profile
                </a>

                <a href="logout"
                   class="block px-4 py-2 text-sm text-red-600 hover:bg-red-50">
                    🚪 Logout
                </a>
            </div>
        </div>
    </div>
</header>

<!-- ================= MAIN CONTENT ================= -->
<main class="max-w-7xl mx-auto px-6 py-8">

    <h2 class="text-xl font-semibold text-gray-800 mb-6">
        Employee Dashboard
    </h2>

    <div class="grid md:grid-cols-2 lg:grid-cols-4 gap-6">

        <div class="bg-white p-6 rounded-xl shadow">
            <h3 class="font-semibold text-gray-700 mb-2">Attendance</h3>
            <p class="text-sm text-gray-500">View your attendance</p>
        </div>

        <div class="bg-white p-6 rounded-xl shadow">
            <h3 class="font-semibold text-gray-700 mb-2">Leave</h3>
            <p class="text-sm text-gray-500">Apply & track leaves</p>
        </div>

        <div class="bg-white p-6 rounded-xl shadow">
            <h3 class="font-semibold text-gray-700 mb-2">Payroll</h3>
            <p class="text-sm text-gray-500">Salary & payslip info</p>
        </div>

        <div class="bg-white p-6 rounded-xl shadow border-2 border-green-600">
            <h3 class="font-semibold text-gray-700 mb-2">Profile</h3>
            <p class="text-sm text-gray-500">Manage your account</p>
        </div>

    </div>

</main>

<!-- ================= FOOTER ================= -->
<footer class="bg-white mt-10 py-4 shadow-inner">
    <p class="text-center text-sm text-gray-400">
        © 2025 Employee Management System
    </p>
</footer>

<!-- ================= JS ================= -->
<script>
function toggleMenu() {
    document.getElementById("profileMenu").classList.toggle("hidden");
}

// Close dropdown on outside click
document.addEventListener("click", function (event) {
    const profileArea = event.target.closest(".relative");
    const menu = document.getElementById("profileMenu");

    if (!profileArea && !menu.classList.contains("hidden")) {
        menu.classList.add("hidden");
    }
});
</script>

</body>
</html>
