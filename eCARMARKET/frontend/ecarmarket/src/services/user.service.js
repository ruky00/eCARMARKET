import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8081/api/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getProfile() {
    return fetch(API_URL + 'me', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Credentials': 'true'
      },
      credentials: 'include'
    })
      .then(response => {
          return response.json();
      })
      .then(data => {
          return data;
        });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();