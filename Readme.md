Weather App Documentation

Overview

The Weather App is a simple Spring Boot application that allows users to enter a city name and retrieve the current weather information for that city. The app uses the Open-Meteo API to fetch the weather data, and it displays the temperature along with a weather description (e.g., Very Cold, Cold, Warm, Hot) based on the temperature. If no city is found, it displays a message indicating that the city could not be found.

Features
1.	City Search: Users can input the name of a city to get the current weather.
2.	Weather Details: The weather information displayed includes:
•	Temperature: The current temperature in Celsius.
•	Weather Description: A description like “Very Cold”, “Cold”, “Warm”, “Hot” based on the temperature.
3.	Error Handling: If the city is not found, an error message “No city found” is displayed.
4.	Frontend Interface: Simple and interactive interface that displays the weather details after entering a city name.


Tech Stack
•	Backend: Spring Boot (Java 21)
•	Frontend: HTML, CSS, JavaScript
•	API: Open-Meteo (for weather data)

Setup and Installation

Prerequisites

Before running the project, ensure the following tools are installed:
•	Java 21 or later
•	Maven (for dependency management)
•	IDE (IntelliJ IDEA, Eclipse, or any Java IDE)
•	Web Browser (for accessing the frontend)


API Usage
•	Endpoint: /weather?city={city_name}
•	Method: GET
•	Request Parameter: city - The name of the city for which you want to fetch weather information.
Example:  GET http://localhost:8080/weather?city=London
Response: The response will contain the current temperature and weather description.
Example:  {
"current_weather": {
"temperature": 20.0,
"weatherDescription": "Warm"
}
}

Frontend

The frontend consists of a simple HTML page where users can input a city name and submit the form. The result is dynamically fetched using JavaScript, which calls the backend API and displays the weather information.

HTML Structure:
•	Input Field: Where users enter the city name.
•	Button: To submit the city name.
•	Weather Info: Where the weather details (temperature and description) will be displayed after fetching the data.

JavaScript Functionality:
•	The JavaScript code listens for the form submission, prevents the default form behavior, and sends an AJAX request to the backend API.
•	If the response is successful, it displays the weather details on the page.
•	If no city is found or there’s an error, it shows the message “No city found”.

Error Handling
•	No City Found: If the user enters an invalid city name or the city is not found, the backend will return a null value, and the frontend will display a “No city found” message.
•	Invalid API Response: If there are issues with the weather API or invalid data is returned, the app will handle the error gracefully and inform the user.