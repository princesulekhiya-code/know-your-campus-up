import { motion } from 'framer-motion';
import { FaBuilding, FaGraduationCap, FaLaptopCode, FaChartLine, FaBriefcase, FaUserTie } from 'react-icons/fa';
import { MdEngineering, MdScience, MdBusiness, MdSchool, MdWork, MdTrendingUp } from 'react-icons/md';

const TopRecruiters = () => {
    const recruiters = [
        { name: "IT Services", icon: FaLaptopCode, color: "text-blue-500" },
        { name: "Engineering", icon: MdEngineering, color: "text-orange-500" },
        { name: "Consulting", icon: FaUserTie, color: "text-purple-600" },
        { name: "Technology", icon: FaBriefcase, color: "text-green-600" },
        { name: "Research", icon: MdScience, color: "text-red-500" },
        { name: "Business", icon: MdBusiness, color: "text-blue-700" },
        { name: "Finance", icon: FaChartLine, color: "text-yellow-600" },
        { name: "Education", icon: FaGraduationCap, color: "text-indigo-600" },
        { name: "Analytics", icon: MdTrendingUp, color: "text-pink-600" },
        { name: "Corporate", icon: FaBuilding, color: "text-gray-700 dark:text-gray-300" },
        { name: "Management", icon: MdWork, color: "text-teal-600" },
        { name: "Academia", icon: MdSchool, color: "text-cyan-600" }
    ];

    return (
        <section className="py-12 bg-white dark:bg-brand-900 border-b border-brand-100 dark:border-brand-800 overflow-hidden">
            <div className="container mx-auto px-4 mb-8 text-center">
                <p className="text-sm font-bold text-brand-500 dark:text-brand-400 uppercase tracking-widest">
                    Top Placement Sectors
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
                    {[...recruiters, ...recruiters, ...recruiters].map((sector, index) => (
                        <div key={index} className="flex items-center space-x-2 opacity-60 hover:opacity-100 transition-opacity duration-300 grayscale hover:grayscale-0 cursor-pointer">
                            <sector.icon className={`text-4xl ${sector.color}`} />
                            <span className="text-xl font-bold text-gray-700 dark:text-gray-300 hidden md:block">{sector.name}</span>
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
