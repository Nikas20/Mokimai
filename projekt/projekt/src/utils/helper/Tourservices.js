import api from '../api';
const url = "/tour";
export const addTour = (payload) => api.post(`${url}`, payload);

export const updateTour = (Id, payload) =>
    api.put(`${url}/${Id}`, payload);
  
  export const getTour = () => api.get(`${url}`);