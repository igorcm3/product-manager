// apiService.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Replace with your API base URL

const apiService = axios.create({
    baseURL: API_BASE_URL,
});

export const fetchCompanies = async () => {
    try {
        const response = await apiService.get('/companies/list');
        return response.data;
    } catch (error) {
        throw error;
    }
};

export const fetchCompanies = async () => {
    try {
        const response = await apiService.get('/companies/list');
        return response.data;
    } catch (error) {
        throw error;
    }
};
