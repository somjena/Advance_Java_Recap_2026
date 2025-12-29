<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Our Team</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-green-50 min-h-screen">

<!-- TOP BAR -->
<header class="bg-white shadow-sm px-8 py-5">
    <h1 class="text-2xl font-bold text-green-700">Our Employees</h1>
    <p class="text-gray-500 text-sm mt-1">
        Building the company together with dedication and excellence
    </p>
</header>

<!-- STATS & ACHIEVEMENTS -->
<section class="grid grid-cols-1 md:grid-cols-3 gap-6 p-8">

    <!-- EMPLOYEE COUNT -->
    <div class="bg-white rounded-2xl shadow p-6 text-center">
        <p class="text-gray-500">Total Employees</p>
        <h2 class="text-4xl font-bold text-green-600 mt-2">48</h2>
    </div>

    <!-- ACHIEVEMENT 1 -->
    <div class="bg-white rounded-2xl shadow p-6 text-center">
        <p class="text-gray-500">Years of Excellence</p>
        <h2 class="text-4xl font-bold text-green-600 mt-2">10+</h2>
    </div>

    <!-- ACHIEVEMENT 2 -->
    <div class="bg-white rounded-2xl shadow p-6 text-center">
        <p class="text-gray-500">Projects Delivered</p>
        <h2 class="text-4xl font-bold text-green-600 mt-2">120+</h2>
    </div>

</section>

<!-- COMPANY ACHIEVEMENTS -->
<section class="px-8 pb-4">
    <div class="bg-white rounded-2xl shadow p-6">
        <h2 class="text-xl font-semibold text-green-700 mb-3">Company Achievements</h2>
        <ul class="list-disc pl-6 text-gray-600 space-y-2">
            <li>ISO 9001:2015 Certified Organization</li>
            <li>Recognized as Best Workplace 2024</li>
            <li>Successfully completed 100+ enterprise projects</li>
            <li>Trusted by clients across 5+ countries</li>
        </ul>
    </div>
</section>

<!-- EMPLOYEE CARDS -->
<section class="p-8">
    <h2 class="text-xl font-semibold text-gray-700 mb-6">Meet Our Team</h2>

    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">

        <!-- CARD -->
        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition">
            <img src="https://i.pravatar.cc/300?img=3"
                 class="rounded-t-2xl w-full h-48 object-cover">
            <div class="p-5 text-center">
                <h3 class="text-lg font-bold text-green-700">Amit Kumar</h3>
                <p class="text-sm text-gray-500">Software Engineer</p>
            </div>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition">
            <img src="https://i.pravatar.cc/300?img=5"
                 class="rounded-t-2xl w-full h-48 object-cover">
            <div class="p-5 text-center">
                <h3 class="text-lg font-bold text-green-700">Sneha Patel</h3>
                <p class="text-sm text-gray-500">HR Manager</p>
            </div>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition">
            <img src="https://i.pravatar.cc/300?img=8"
                 class="rounded-t-2xl w-full h-48 object-cover">
            <div class="p-5 text-center">
                <h3 class="text-lg font-bold text-green-700">Rahul Das</h3>
                <p class="text-sm text-gray-500">Finance Executive</p>
            </div>
        </div>

        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition">
            <img src="https://i.pravatar.cc/300?img=12"
                 class="rounded-t-2xl w-full h-48 object-cover">
            <div class="p-5 text-center">
                <h3 class="text-lg font-bold text-green-700">Priya Singh</h3>
                <p class="text-sm text-gray-500">Team Lead</p>
            </div>
        </div>

    </div>
</section>

<!-- FOOTER -->
<footer class="text-center text-gray-500 py-6">
    © 2025 Your Company Name
</footer>

</body>
</html>
