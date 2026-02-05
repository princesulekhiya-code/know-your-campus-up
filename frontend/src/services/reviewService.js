import api from './api';

export const reviewService = {
    // Public endpoints
    getByCollegeId: (collegeId) => api.get(`/reviews/college/${collegeId}`),
    getCollegeStats: (collegeId) => api.get(`/reviews/college/${collegeId}/stats`),
    create: (data) => api.post('/reviews', data),

    // Admin endpoints
    getAllReviews: () => api.get('/reviews/admin/all'),
    getPendingReviews: () => api.get('/reviews/admin/pending'),
    approveReview: (reviewId) => api.put(`/reviews/admin/${reviewId}/approve`),
    updateReview: (reviewId, data) => api.put(`/reviews/admin/${reviewId}`, data),
    deleteReview: (reviewId) => api.delete(`/reviews/admin/${reviewId}`),
};

export default reviewService;
