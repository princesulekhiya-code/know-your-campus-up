import api from './api';
            // hello   service the  notfication of the collage and the admin  can add
export const notificationService = {
    // Get active notifications (public)
    getActive: () => api.get('/notifications/active'),

    // Get all notifications (admin only)
    getAll: () => api.get('/notifications/all'),


    // get notifation  by 

    // Create notification (admin only)
    create: (data) => api.post('/notifications', data),

    // Toggle active status (admin only)
    toggleStatus: (id) => api.put(`/notifications/${id}/toggle`),



    

    // Delete notification (admin only)
    delete: (id) => api.delete(`/notifications/${id}`),
};

export default notificationService;
