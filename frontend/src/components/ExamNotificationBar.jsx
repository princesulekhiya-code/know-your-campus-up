import { motion } from 'framer-motion';
import { FiCalendar, FiAlertCircle } from 'react-icons/fi';
import { useEffect, useState, useRef } from 'react';
import notificationService from '../services/notificationService';

const ExamNotificationBar = () => {
    const [notifications, setNotifications] = useState([]);
    const [shouldScroll, setShouldScroll] = useState(false);
    const containerRef = useRef(null);
    const contentRef = useRef(null);

    const defaultNotifications = [
        {
            id: 'default-1',
            text: '🔥 NEET UG 2026 Exam Schedule & MP State Quota Seats Announced - Apply Now',
            eventDate: 'MAY 2026',
            isUrgent: true,
            link: '/admission'
        },
        {
            id: 'default-2',
            text: '🎓 MP DME Medical Counselling 2026: Choice Filling for MBBS & BDS Seats Starts Soon',
            eventDate: 'JUN 2026',
            isUrgent: true,
            link: '/admission'
        },
        {
            id: 'default-3',
            text: '🌿 Top Private BAMS (Ayurveda) Colleges in Bhopal Admissions Open 2026-27',
            eventDate: 'OPEN NOW',
            isUrgent: false,
            link: '/colleges'
        },
        {
            id: 'default-4',
            text: '🦷 Peoples & Mansarovar Dental College Bhopal BDS Seat Matrix & Fee Details Released',
            eventDate: 'UPDATED',
            isUrgent: false,
            link: '/colleges'
        }
    ];

    useEffect(() => {
        const fetchNotifications = async () => {
            try {
                const response = await notificationService.getActive();
                if (response.data && response.data.length > 0) {
                    setNotifications(response.data);
                } else {
                    setNotifications(defaultNotifications);
                }
            } catch (error) {
                console.error('Failed to fetch notifications, using default updates:', error);
                setNotifications(defaultNotifications);
            }
        };

        fetchNotifications();
    }, []);

    useEffect(() => {
        const checkScroll = () => {
            if (containerRef.current && contentRef.current) {
                const containerWidth = containerRef.current.offsetWidth;
                const contentWidth = contentRef.current.scrollWidth;
                // Enable scroll only if content is wider than container
                setShouldScroll(contentWidth > containerWidth);
            }
        };

        // Check initially and on resize
        checkScroll();
        window.addEventListener('resize', checkScroll);

        // Small timeout to ensure DOM is rendered before measuring
        const timer = setTimeout(checkScroll, 100);

        return () => {
            window.removeEventListener('resize', checkScroll);
            clearTimeout(timer);
        };
    }, [notifications]);

    const activeList = notifications.length > 0 ? notifications : defaultNotifications;

    const NotificationItem = ({ note }) => (
        <span className="inline-flex items-center space-x-3 text-sm text-brand-50 relative z-20">
            <FiCalendar className="w-4 h-4 text-action-400 flex-shrink-0" />
            {note.eventDate && (
                <span className="bg-action-600 text-white text-xs px-2 py-0.5 rounded font-bold">
                    {note.eventDate}
                </span>
            )}
            {note.link ? (
                <a href={note.link} className={`hover:underline hover:text-white transition-colors ${note.isUrgent ? "font-bold text-white" : ""}`}>
                    {note.text}
                </a>
            ) : (
                <span className={note.isUrgent ? "font-bold text-white" : ""}>{note.text}</span>
            )}
        </span>
    );

    return (
        <div className="bg-brand-900 border-b border-brand-800 text-white overflow-hidden py-3 relative z-40">
            <div className="container mx-auto px-4 flex items-center">
                <div className="flex items-center space-x-2 bg-action-600 px-3 py-1 rounded-md text-xs font-bold mr-4 z-10 shadow-lg whitespace-nowrap">
                    <FiAlertCircle className="w-4 h-4" />
                    <span>LATEST UPDATES</span>
                </div>

                <div className="flex-1 overflow-hidden relative h-6 flex items-center" ref={containerRef}>
                    {shouldScroll ? (
                        <motion.div
                            className="flex items-center whitespace-nowrap pl-4"
                            animate={{ x: ["-0%", "-50%"] }}
                            transition={{
                                repeat: Infinity,
                                duration: Math.max(20, activeList.length * 8),
                                ease: "linear"
                            }}
                            style={{ width: "fit-content", minWidth: "200%" }}
                        >
                            {/* First Set */}
                            <div className="flex items-center space-x-16 pr-16">
                                {activeList.map((note, index) => (
                                    <NotificationItem key={`orig-${index}`} note={note} />
                                ))}
                            </div>
                            {/* Duplicate Set for Loop */}
                            <div className="flex items-center space-x-16 pr-16">
                                {activeList.map((note, index) => (
                                    <NotificationItem key={`dup-${index}`} note={note} />
                                ))}
                            </div>
                        </motion.div>
                    ) : (
                        // Static content for measurement and display if short
                        <div ref={contentRef} className="flex items-center whitespace-nowrap pl-4 w-full">
                            <div className="flex items-center space-x-16">
                                {activeList.map((note, index) => (
                                    <NotificationItem key={index} note={note} />
                                ))}
                            </div>
                        </div>
                    )}

                    {/* Gradients for smooth fade on edges */}
                    <div className="absolute top-0 left-0 h-full w-12 bg-gradient-to-r from-brand-900 to-transparent z-30 pointer-events-none"></div>
                    <div className="absolute top-0 right-0 h-full w-12 bg-gradient-to-l from-brand-900 to-transparent z-30 pointer-events-none"></div>
                </div>
            </div>
        </div>
    );
};

export default ExamNotificationBar;

