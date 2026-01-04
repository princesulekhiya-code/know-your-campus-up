import { motion } from 'framer-motion';
import { FiCalendar, FiClock, FiAlertCircle } from 'react-icons/fi';

const ExamNotificationBar = () => {
    const notifications = [
        { text: "JEE Main 2024 Registration closes on January 15th!", urgent: true },
        { text: "NEET UG 2024 Application forms available now.", urgent: false },
        { text: "BITSAT 2024 Exam Dates Announced - Check Now", urgent: true },
        { text: "VITEEE 2024 Slot Booking starts next week", urgent: false },
        { text: "GATE 2024 Admit Cards Released", urgent: true }
    ];

    return (
        <div className="bg-brand-900 border-b border-brand-800 text-white overflow-hidden py-3 relative z-40">
            <div className="container mx-auto px-4 flex items-center">
                <div className="flex items-center space-x-2 bg-action-600 px-3 py-1 rounded-md text-xs font-bold mr-4 z-10 shadow-lg whitespace-nowrap">
                    <FiAlertCircle className="w-4 h-4" />
                    <span>LATEST UPDATES</span>
                </div>

                <div className="flex-1 overflow-hidden relative">
                    <motion.div
                        className="flex items-center space-x-12 whitespace-nowrap"
                        animate={{ x: ["100%", "-100%"] }}
                        transition={{
                            repeat: Infinity,
                            duration: 25,
                            ease: "linear"
                        }}
                    >
                        {[...notifications, ...notifications].map((note, index) => (
                            <span key={index} className="flex items-center space-x-2 text-sm text-brand-100">
                                <FiCalendar className="w-4 h-4 text-action-400" />
                                <span className={note.urgent ? "font-semibold text-white" : ""}>{note.text}</span>
                            </span>
                        ))}
                    </motion.div>

                    {/* Gradients for smooth fade on edges */}
                    <div className="absolute top-0 left-0 h-full w-8 bg-gradient-to-r from-brand-900 to-transparent z-10"></div>
                    <div className="absolute top-0 right-0 h-full w-8 bg-gradient-to-l from-brand-900 to-transparent z-10"></div>
                </div>
            </div>
        </div>
    );
};

export default ExamNotificationBar;
