<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Departments</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-green-50 min-h-screen flex flex-col">

<!-- HEADER -->
<header class="bg-white shadow-sm px-8 py-5">
    <h1 class="text-2xl font-bold text-green-700">Departments</h1>
    <p class="text-gray-500 text-sm mt-1">
        Organized teams driving innovation and success
    </p>
</header>

<!-- DEPARTMENT CARDS -->
<section class="p-8 flex-grow">
    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">

        <!-- CARD -->
        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Information Technology</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">18</p>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Human Resources</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">6</p>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Finance</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">8</p>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Operations</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">10</p>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Marketing</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">4</p>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition p-6 text-center">
            <h2 class="text-xl font-semibold text-green-700">Administration</h2>
            <p class="text-gray-500 mt-2">Employees</p>
            <p class="text-4xl font-bold text-green-600 mt-1">2</p>
        </div>

    </div>
</section>

<!-- FOOTER -->
<footer class="bg-white border-t border-green-100 mt-8">
    <div class="max-w-7xl mx-auto px-8 py-6 grid grid-cols-1 md:grid-cols-3 gap-6">

        <!-- COMPANY -->
        <div>
            <h3 class="text-lg font-semibold text-green-700">Your Company</h3>
            <p class="text-sm text-gray-500 mt-2">
                Building strong teams and delivering excellence through collaboration and innovation.
            </p>
        </div>

        <!-- QUICK LINKS -->
        <div>
            <h3 class="text-lg font-semibold text-green-700">Quick Links</h3>
            <ul class="text-sm text-gray-500 mt-2 space-y-1">
                <li><a href="employees.jsp" class="hover:text-green-600">Employees</a></li>
                <li><a href="departments.jsp" class="hover:text-green-600">Departments</a></li>
                <li><a href="#" class="hover:text-green-600">Company Policies</a></li>
            </ul>
        </div>

        <!-- CONTACT -->
        <div>
            <h3 class="text-lg font-semibold text-green-700">Contact</h3>
            <p class="text-sm text-gray-500 mt-2">
                Email: info@yourcompany.com<br>
                Phone: +91 98765 43210
            </p>
        </div>

    </div>

    <div class="text-center text-sm text-gray-400 py-4 border-t border-green-100">
        © 2025 Your Company Name. All rights reserved.
    </div>
</footer>

</body>
</html>
