import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';  // Định nghĩa base URL của API

export const apiGet = async (endpoint: string, params: object) => {
  try {
    const response = await axios.get(`${BASE_URL}/${endpoint}`,{
      params: params
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const apiPost = async (endpoint: string, params: object) => {
  try {
    const response = await axios.post(`${BASE_URL}/${endpoint}`, params);
    return response.data;
  } catch (error) {
    throw error;
  }
};
