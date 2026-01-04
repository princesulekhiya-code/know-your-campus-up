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
    update: (id, data) => api.put(`/seats/${id}`, data),
};

export const feeService = {
    getByCourseId: (courseId) => api.get(`/fees/course/${courseId}`),
    update: (id, data) => api.put(`/fees/${id}`, data),
};

export const cutoffService = {
    getByCourseId: (courseId) => api.get(`/cutoffs/course/${courseId}`),
};

export default collegeService;
