document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');

    // Simple validation
    if (email === '' || password === '') {
        errorMessage.textContent = 'Both fields are required.';
    } else if (password.length < 6) {
        errorMessage.textContent = 'Password must be at least 6 characters long.';
    } else {
        errorMessage.textContent = '';
        // Proceed with form submission or further validation
        alert('Login successful!');
        // Redirect to the content page
        window.location.href = 'content.html';
    }
});