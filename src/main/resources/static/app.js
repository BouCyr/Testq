// app.js

// Function to fetch data from an API
async function fetchData(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return await response.json();
    } catch (error) {
        console.error('Fetch error:', error);
    }
}

// Function to handle UI interactions
function handleButtonClick() {
    const button = document.getElementById('myButton');
    button.addEventListener('click', async () => {
        const data = await fetchData('https://api.example.com/data');
        console.log(data);
        // Add more UI interaction logic here
    });
}

// Initialize the app
document.addEventListener('DOMContentLoaded', () => {
    handleButtonClick();
});