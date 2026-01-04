import { motion } from 'framer-motion';
import { FiSearch, FiGitPullRequest, FiCheckCircle } from 'react-icons/fi';

const HowItWorks = () => {
    const steps = [
        {
            id: 1,
            title: "Search College",
            desc: "Browse through our verified database of colleges by stream, location, or exam.",
            icon: FiSearch,
            color: "text-blue-500",
            bg: "bg-blue-50 dark:bg-blue-900/30",
            border: "border-blue-200 dark:border-blue-700"
        },
        {
            id: 2,
            title: "Compare Details",
            desc: "Compare fees, placements, and facilities side-by-side to make the best choice.",
            icon: FiGitPullRequest, // Using GitPullRequest as a metaphor for comparison/branches
            color: "text-purple-500",
            bg: "bg-purple-50 dark:bg-purple-900/30",
            border: "border-purple-200 dark:border-purple-700"
        },
        {
            id: 3,
            title: "Apply for Admission",
            desc: "Check eligibility and apply directly to your dream college with our guidance.",
            icon: FiCheckCircle,
            color: "text-green-500",
            bg: "bg-green-50 dark:bg-green-900/30",
            border: "border-green-200 dark:border-green-700"
        }
    ];

    return (
        <section className="py-20 bg-white dark:bg-brand-900">
            <div className="container mx-auto px-4">
                <div className="text-center mb-16">
                    <span className="text-action-600 dark:text-action-400 font-bold uppercase tracking-wider text-sm mb-2 block">
                        Simple Process
                    </span>
                    <h2 className="text-4xl font-bold text-brand-900 dark:text-white mb-4">
                        How It Works
                    </h2>
                    <p className="text-xl text-brand-600 dark:text-brand-400 max-w-2xl mx-auto">
                        Get admission in your dream college in 3 simple steps
                    </p>
                </div>

                <div className="grid grid-cols-1 md:grid-cols-3 gap-8 relative">
                    {/* Connecting Line (Desktop) */}
                    <div className="hidden md:block absolute top-1/2 left-0 w-full h-1 bg-gradient-to-r from-transparent via-brand-200 dark:via-brand-700 to-transparent -translate-y-1/2 z-0"></div>

                    {steps.map((step, index) => (
                        <motion.div
                            key={step.id}
                            initial={{ opacity: 0, y: 30 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ duration: 0.5, delay: index * 0.2 }}
                            className="relative z-10 text-center"
                        >
                            <div className={`w-24 h-24 mx-auto ${step.bg} rounded-full flex items-center justify-center border-4 ${step.border} mb-6 shadow-lg group hover:scale-110 transition-transform duration-300 bg-white dark:bg-brand-800`}>
                                <step.icon className={`w-10 h-10 ${step.color}`} />
                                <div className="absolute -top-2 -right-2 w-8 h-8 bg-brand-900 text-white rounded-full flex items-center justify-center font-bold border-2 border-white dark:border-brand-800 shadow-md">
                                    {step.id}
                                </div>
                            </div>

                            <h3 className="text-2xl font-bold text-brand-900 dark:text-white mb-3">
                                {step.title}
                            </h3>
                            <p className="text-brand-600 dark:text-brand-400 leading-relaxed px-4">
                                {step.desc}
                            </p>
                        </motion.div>
                    ))}
                </div>
            </div>
        </section>
    );
};

export default HowItWorks;
