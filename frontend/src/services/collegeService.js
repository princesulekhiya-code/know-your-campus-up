import api from './api';

const getCache = (key) => {
    try {
        const item = sessionStorage.getItem(key);
        if (item) return JSON.parse(item);
    } catch (e) { }
    return null;
};

const setCache = (key, data) => {
    try {
        sessionStorage.setItem(key, JSON.stringify(data));
    } catch (e) { }
};

export const collegeService = {
    // Get all colleges with optional filters (Instant 0ms caching)
    getAll: async (filters = {}) => {
        const params = new URLSearchParams();
        Object.keys(filters).forEach(key => {
            if (filters[key]) params.append(key, filters[key]);
        });
        const cacheKey = `colleges_all_${params.toString()}`;
        const cachedData = getCache(cacheKey);

        const promise = api.get(`/colleges?${params.toString()}`).then(res => {
            setCache(cacheKey, res.data);
            return res;
        });

        if (cachedData) {
            return { data: cachedData, fromCache: true };
        }
        return promise;
    },

    // Get college by ID (Instant 0ms caching)
    getById: async (id) => {
        const cacheKey = `college_id_${id}`;
        const cachedData = getCache(cacheKey);

        const promise = api.get(`/colleges/${id}`).then(res => {
            setCache(cacheKey, res.data);
            return res;
        });

        if (cachedData) {
            return { data: cachedData, fromCache: true };
        }
        return promise;
    },

    // Search colleges
    search: async (query) => {
        const cacheKey = `college_search_${query}`;
        const cachedData = getCache(cacheKey);

        const promise = api.get(`/colleges/search?q=${query}`).then(res => {
            setCache(cacheKey, res.data);
            return res;
        });

        if (cachedData) {
            return { data: cachedData, fromCache: true };
        }
        return promise;
    },

    // Create college (admin only)
    create: (data) => {
        sessionStorage.clear();
        return api.post('/colleges', data);
    },

    // Update college (admin only)
    update: (id, data) => {
        sessionStorage.clear();
        return api.put(`/colleges/${id}`, data);
    },

    // Delete college (admin only)
    delete: (id) => {
        sessionStorage.clear();
        return api.delete(`/colleges/${id}`);
    },
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
