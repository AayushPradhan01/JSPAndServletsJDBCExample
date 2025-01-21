<!DOCTYPE html>
<html>
<head>
    <title>User Information Form</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h2>User Information Form</h2>
<form action="<%=application.getContextPath()%>/form" method="post">
    <!-- First Name -->
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>

    <!-- Last Name -->
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required>


    <!-- Gender Selection -->
    <label>Gender:</label>
    <div class="gender">
        <label><input type="radio" name="gender" value="Male" required> Male</label>
        <label><input type="radio" name="gender" value="Female"> Female</label>
        <label><input type="radio" name="gender" value="Other"> Other</label>
    </div>


    <!-- Date of Birth -->
    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" required>

    <!-- Email ID -->
    <label for="email">Email ID:</label>
    <input type="email" id="email" name="email" required>



    <!-- Car Dropdown Menu -->
    <label for="car">Select Your Car:</label>
    <select id="car" name="car">
        <option value="">--Select Car--</option>
        <option value="Maruti Suzuki Alto 800">Maruti Suzuki Alto 800</option>
        <option value="Maruti Suzuki Swift">Maruti Suzuki Swift</option>
        <option value="Maruti Suzuki Dzire">Maruti Suzuki Dzire</option>
        <option value="Maruti Suzuki Baleno">Maruti Suzuki Baleno</option>
        <option value="Maruti Suzuki WagonR">Maruti Suzuki WagonR</option>
        <option value="Hyundai Creta">Hyundai Creta</option>
        <option value="Hyundai i20">Hyundai i20</option>
        <option value="Hyundai Venue">Hyundai Venue</option>
        <option value="Tata Tiago">Tata Tiago</option>
        <option value="Tata Nexon">Tata Nexon</option>
        <option value="Tata Harrier">Tata Harrier</option>
        <option value="Tata Altroz">Tata Altroz</option>
        <option value="Mahindra Thar">Mahindra Thar</option>
        <option value="Mahindra Scorpio-N">Mahindra Scorpio-N</option>
        <option value="Mahindra Bolero">Mahindra Bolero</option>
        <option value="Toyota Innova Crysta">Toyota Innova Crysta</option>
        <option value="Toyota Fortuner">Toyota Fortuner</option>
        <option value="Honda City">Honda City</option>
        <option value="Kia Seltos">Kia Seltos</option>
        <option value="Kia Sonet">Kia Sonet</option>
    </select>



    <!-- Buttons -->
    <button type="reset">Reset</button>
    <button type="submit">Submit</button>
</form>
</body>
</html>
