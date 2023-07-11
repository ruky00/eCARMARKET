import axios from 'axios';

const API_URL = 'http://localhost:8081/api/auth/';

class AuthService {
  async login(user) {
    return fetch(API_URL + 'login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Credentials': 'true'
        },
        body: JSON.stringify({
          username: user.username,
          password: user.password
        })
      })
        .then(response => {
            console.log(response);
            const cookies = response.headers.get('Set-Cookie');
            console.log(cookies);
            const cookiesFromDocument = document.cookie;
            console.log(cookiesFromDocument);
            return response.json();
        })
        .then(data => {
            console.log(data);
            return data;
          });
  }

  async getToken() {
    
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(user) {
    return axios.post(API_URL + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password
    });
  }
}

export default new AuthService();