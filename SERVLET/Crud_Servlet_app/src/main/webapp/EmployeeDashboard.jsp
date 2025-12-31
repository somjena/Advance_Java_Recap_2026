<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="util.DButil" %>

<%
/* ================= SESSION CHECK ================= */
HttpSession s = request.getSession(false);
if (s == null || s.getAttribute("empid") == null) {
    response.sendRedirect("login.html");
    return;
}

String empid = s.getAttribute("empid").toString();
String empname = s.getAttribute("empname").toString();

/* ================= TIME FETCH (DB IS SOURCE OF TRUTH) ================= */
boolean alreadyCheckedIn = false;
boolean dayCompleted = false;
long elapsedSeconds = 0;

try (Connection con = DButil.getConnection()) {

    String sql =
        "SELECT check_in, check_out, worked_seconds " +
        "FROM attendance WHERE emp_id=? AND work_date=CURDATE()";

    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, empid);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        Timestamp checkIn = rs.getTimestamp("check_in");
        Timestamp checkOut = rs.getTimestamp("check_out");
        long worked = Math.max(0, rs.getLong("worked_seconds"));

        long nowSec = System.currentTimeMillis() / 1000;

        // 🔥 Currently Checked-In
        if (checkIn != null && checkOut == null) {
            alreadyCheckedIn = true;
            long checkInSec = checkIn.getTime() / 1000;
            long running = Math.max(0, nowSec - checkInSec);
            elapsedSeconds = worked + running;
        }

        // 🔒 Day Completed
        if (checkIn != null && checkOut != null) {
            dayCompleted = true;
            elapsedSeconds = worked;
        }
    }
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 min-h-screen">

<!-- ================= HEADER ================= -->
<header class="bg-white shadow">
    <div class="max-w-7xl mx-auto px-6 py-4 flex justify-between items-center">

        <h1 class="text-2xl font-bold text-green-600">EMS</h1>

        <div class="flex items-center gap-4">

            <!-- CHECK IN / CHECK OUT -->
            <div class="flex items-center gap-2">
                <button onclick="toggleCheck()"
                        <%= dayCompleted ? "disabled" : "" %>
                        class="px-4 py-1.5 text-xs rounded-md text-white
                        <%= dayCompleted ? "bg-gray-400 cursor-not-allowed" :
                            alreadyCheckedIn ? "bg-red-600 hover:bg-red-700"
                                             : "bg-green-600 hover:bg-green-700" %>">

                    <%= dayCompleted ? "Day Completed" :
                        alreadyCheckedIn ? "Check Out" : "Check In" %>
                </button>

                <span id="timer"
                      class="text-xs font-semibold text-gray-600
                      <%= alreadyCheckedIn ? "" : "hidden" %>">
                </span>
            </div>

            <!-- PROFILE -->
            <div class="flex items-center gap-2">
                <img src="profileImage?id=<%= empid %>"
                     class="w-10 h-10 rounded-full border-2 border-green-600 object-cover"
                     onerror="this.src='images/default.png'">
                <span class="font-medium text-gray-700"><%= empname %></span>
            </div>

        </div>
    </div>
</header>

<!-- ================= MAIN ================= -->
<main class="max-w-7xl mx-auto px-6 py-8">

    <h2 class="text-xl font-semibold mb-6">
        Welcome, <span class="text-green-600"><%= empname %></span>
    </h2>

    <!-- ================= ATTENDANCE HISTORY ================= -->
    <div class="bg-white p-6 rounded-xl shadow">

        <h3 class="font-semibold mb-4">Attendance History</h3>

        <table class="w-full text-sm border">
            <tr class="bg-green-50 text-green-700">
                <th class="border p-2">Date</th>
                <th class="border p-2">Check In</th>
                <th class="border p-2">Check Out</th>
                <th class="border p-2">Seconds</th>
            </tr>

            <%
            try (Connection con = DButil.getConnection()) {
                PreparedStatement ps =
                    con.prepareStatement(
                        "SELECT work_date, check_in, check_out, worked_seconds " +
                        "FROM attendance WHERE emp_id=? ORDER BY work_date DESC");
                ps.setString(1, empid);
                ResultSet rs = ps.executeQuery();

                boolean found = false;
                while (rs.next()) {
                    found = true;
            %>
            <tr class="text-center">
                <td class="border p-2"><%= rs.getDate("work_date") %></td>
                <td class="border p-2"><%= rs.getTimestamp("check_in") %></td>
                <td class="border p-2"><%= rs.getTimestamp("check_out") %></td>
                <td class="border p-2"><%= Math.max(0, rs.getLong("worked_seconds")) %></td>
            </tr>
            <%
                }
                if (!found) {
            %>
            <tr>
                <td colspan="4" class="p-4 text-center text-gray-500">
                    No attendance records found
                </td>
            </tr>
            <%
                }
            }
            %>

        </table>
    </div>

</main>

<!-- ================= JS ================= -->
<script>
let isCheckedIn = <%= alreadyCheckedIn %>;
let seconds = <%= elapsedSeconds %>;

if (isCheckedIn) startTimer();

function toggleCheck() {
    fetch(isCheckedIn ? "checkout" : "checkin", { method: "POST" })
        .then(() => location.reload());
}

function startTimer() {
    const timer = document.getElementById("timer");
    timer.classList.remove("hidden");

    // 🔥 SHOW DB TIME IMMEDIATELY
    timer.textContent = seconds + " sec";

    setInterval(() => {
        seconds++;
        timer.textContent = seconds + " sec";
    }, 1000);
}
</script>

</body>
</html>
