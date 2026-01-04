import { motion } from 'framer-motion';
import { FaGoogle, FaAmazon, FaMicrosoft, FaApple, FaUber, FaSpotify, FaSlack } from 'react-icons/fa';
import { SiInfosys, SiTcs, SiAccenture, SiDell, SiIbm, SiIntel, SiOracle } from 'react-icons/si';

const TopRecruiters = () => {
    const recruiters = [
        { name: "Google", icon: FaGoogle, color: "text-red-500" },
        { name: "Microsoft", icon: FaMicrosoft, color: "text-blue-500" },
        { name: "Amazon", icon: FaAmazon, color: "text-yellow-600" },
        { name: "Infosys", icon: SiInfosys, color: "text-blue-600" },
        { name: "TCS", icon: SiTcs, color: "text-black dark:text-white" },
        { name: "Accenture", icon: SiAccenture, color: "text-purple-600" },
        { name: "Apple", icon: FaApple, color: "text-gray-800 dark:text-white" },
        { name: "Dell", icon: SiDell, color: "text-blue-700" },
        { name: "IBM", icon: SiIbm, color: "text-blue-800" },
        { name: "Intel", icon: SiIntel, color: "text-blue-500" },
        { name: "Oracle", icon: SiOracle, color: "text-red-600" },
        { name: "Uber", icon: FaUber, color: "text-black dark:text-white" }
    ];

    return (
        <section className="py-12 bg-white dark:bg-brand-900 border-b border-brand-100 dark:border-brand-800 overflow-hidden">
            <div className="container mx-auto px-4 mb-8 text-center">
                <p className="text-sm font-bold text-brand-500 dark:text-brand-400 uppercase tracking-widest">
                    Trusted by Top Companies
                </p>
            </div>

            <div className="relative flex overflow-x-hidden group">
                <motion.div
                    className="flex space-x-12 whitespace-nowrap py-4"
                    animate={{ x: [0, -1000] }}
                    transition={{
                        repeat: Infinity,
                        duration: 30,
                        ease: "linear",
                    }}
                >
                    {[...recruiters, ...recruiters, ...recruiters].map((company, index) => (
                        <div key={index} className="flex items-center space-x-2 opacity-60 hover:opacity-100 transition-opacity duration-300 grayscale hover:grayscale-0 cursor-pointer">
                            <company.icon className={`text-4xl ${company.color}`} />
                            <span className="text-xl font-bold text-gray-700 dark:text-gray-300 hidden md:block">{company.name}</span>
                        </div>
                    ))}
                </motion.div>

                {/* Gradients for smooth fade on edges */}
                <div className="absolute top-0 left-0 h-full w-20 bg-gradient-to-r from-white dark:from-brand-900 to-transparent z-10"></div>
                <div className="absolute top-0 right-0 h-full w-20 bg-gradient-to-l from-white dark:from-brand-900 to-transparent z-10"></div>
            </div>
        </section>
    );
};

export default TopRecruiters;
