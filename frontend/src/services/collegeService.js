import api from './api';

export const collegeService = {
    // Get all colleges with optional filters
    getAll: (filters = {}) => {
        const params = new URLSearchParams();
        Object.keys(filters).forEach(key => {
            if (filters[key]) params.append(key, filters[key]);
        });
        return api.get(`/colleges?${params.toString()}`);
    },

    // Get college by ID
    getById: (id) => api.get(`/colleges/${id}`),

    // Search colleges
    search: (query) => api.get(`/colleges/search?q=${query}`),

    // Create college (admin only)
    create: (data) => api.post('/colleges', data),

    // Update college (admin only)
    update: (id, data) => api.put(`/colleges/${id}`, data),

    // Delete college (admin only)
    delete: (id) => api.delete(`/colleges/${id}`),
};

export const courseService = {
    getByCollegeId: (collegeId) => api.get(`/courses/college/${collegeId}`),
    getById: (id) => api.get(`/courses/${id}`),
    create: (data) => api.post('/courses', data),
    update: (id, data) => api.put(`/courses/${id}`, data),
    delete: (id) => api.delete(`/courses/${id}`),
};

export const seatService = {
    getByCourseId: (courseId) => api.get(`/seats/course/${courseId}`),
    create: (data) => api.post('/seats', data),
    update: (id, data) => api.put(`/seats/${id}`, data),
    delete: (id) => api.delete(`/seats/${id}`),
};

export const feeService = {
    getByCourseId: (courseId) => api.get(`/fees/course/${courseId}`),
    create: (data) => api.post('/fees', data),
    update: (id, data) => api.put(`/fees/${id}`, data),
    delete: (id) => api.delete(`/fees/${id}`),
};

export const cutoffService = {
    getByCourseId: (courseId) => api.get(`/cutoffs/course/${courseId}`),
    create: (data) => api.post('/cutoffs', data),
    update: (id, data) => api.put(`/cutoffs/${id}`, data),
    delete: (id) => api.delete(`/cutoffs/${id}`),
};

export default collegeService;
