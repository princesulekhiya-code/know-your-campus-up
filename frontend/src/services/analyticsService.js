import api from './api';

export const analyticsService = {
    // Get dashboard data (admin only)
    getDashboard: () => api.get('/analytics/dashboard'),
};

export const trackingService = {
    // Track page visit (public)
    trackVisit: (data) => api.post('/tracking', data),

    // Get college view count (public)
    getCollegeViews: (collegeId) => api.get(`/tracking/college/${collegeId}/views`),
};

export const authService = {
    // Admin login
    login: (email, password) => api.post('/auth/login', { email, password }),
};

export default analyticsService;
