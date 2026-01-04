import api from './api';

export const leadService = {
    // Submit lead (public)
    submit: (data) => api.post('/leads/submit', data),

    // Get all leads (admin only)
    getAll: () => api.get('/leads'),

    // Get lead by ID (admin only)
    getById: (id) => api.get(`/leads/${id}`),

    // Get leads by status (admin only)
    getByStatus: (status) => api.get(`/leads/status/${status}`),

    // Get leads by college (admin only)
    getByCollege: (collegeId) => api.get(`/leads/college/${collegeId}`),

    // Update lead status (admin only)
    updateStatus: (id, status, remarks) => {
        const params = new URLSearchParams({ status });
        if (remarks) params.append('remarks', remarks);
        return api.put(`/leads/${id}/status?${params.toString()}`);
    },
};

export default leadService;
