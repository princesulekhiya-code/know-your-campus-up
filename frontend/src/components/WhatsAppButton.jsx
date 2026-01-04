import { motion } from 'framer-motion';
import { FaWhatsapp } from 'react-icons/fa';

const WhatsAppButton = () => {
    const phoneNumber = '919009536046'; // India country code + your number
    const message = encodeURIComponent('Hello! I would like to know more about college admissions.');
    const whatsappUrl = `https://wa.me/${phoneNumber}?text=${message}`;

    return (
        <motion.a
            href={whatsappUrl}
            target="_blank"
            rel="noopener noreferrer"
            className="fixed bottom-6 right-6 z-50 group"
            initial={{ scale: 0 }}
            animate={{ scale: 1 }}
            whileHover={{ scale: 1.1 }}
            whileTap={{ scale: 0.9 }}
            transition={{ type: 'spring', stiffness: 260, damping: 20 }}
        >
            <div className="relative">
                {/* Pulse Animation */}
                <div className="absolute inset-0 bg-green-500 rounded-full animate-ping opacity-75"></div>

                {/* Button */}
                <div className="relative bg-gradient-to-br from-green-500 to-green-600 hover:from-green-600 hover:to-green-700 text-white p-4 rounded-full shadow-lg hover:shadow-xl transition-all duration-300">
                    <FaWhatsapp className="w-7 h-7" />
                </div>

                {/* Tooltip */}
                <div className="absolute right-full mr-3 top-1/2 -translate-y-1/2 opacity-0 group-hover:opacity-100 transition-opacity duration-300 pointer-events-none">
                    <div className="bg-brand-900 dark:bg-white text-white dark:text-brand-900 px-4 py-2 rounded-lg shadow-lg whitespace-nowrap text-sm font-medium">
                        Chat with us on WhatsApp
                        <div className="absolute right-0 top-1/2 -translate-y-1/2 translate-x-1/2 rotate-45 w-2 h-2 bg-brand-900 dark:bg-white"></div>
                    </div>
                </div>
            </div>
        </motion.a>
    );
};

export default WhatsAppButton;
