import { trackingService } from '../services/analyticsService';

export const trackPageVisit = async (pagePath, pageTitle, collegeId = null, courseId = null) => {
    try {
        const sessionId = getOrCreateSessionId();

        await trackingService.trackVisit({
            pagePath,
            pageTitle,
            collegeId,
            courseId,
            sessionId,
            referrer: document.referrer || 'direct',
        });
    } catch (error) {
        // Silently fail - tracking is optional
    }
};

const getOrCreateSessionId = () => {
    let sessionId = sessionStorage.getItem('sessionId');
    if (!sessionId) {
        sessionId = `session_${Date.now()}_${Math.random().toString(36).substr(2, 9)}`;
        sessionStorage.setItem('sessionId', sessionId);
    }
    return sessionId;
};

export default trackPageVisit;
