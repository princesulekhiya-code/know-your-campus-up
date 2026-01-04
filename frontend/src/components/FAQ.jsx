import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { FiPlus, FiMinus, FiHelpCircle } from 'react-icons/fi';

const FAQ = () => {
    const faqs = [
        {
            question: "Is Know Your Campus completely free to use?",
            answer: "Yes! Our platform is 100% free for students. You can search colleges, compare fees, and access admission details without any hidden charges."
        },
        {
            question: "How accurate is the fee structure and cutoff data?",
            answer: "We update our database regularly directly from official college notifications and past year counselling records to ensure high accuracy."
        },
        {
            question: "Can I apply to colleges directly through this portal?",
            answer: "We provide direct links to official college admission forms and guidance on how to apply. For some partner colleges, you can express interest directly."
        },
        {
            question: "Do you offer personalized counselling?",
            answer: "Yes, we have a team of expert counsellors. You can join our WhatsApp group or call our support number to get personalized guidance for your career."
        },
        {
            question: "How do I compare two colleges?",
            answer: "Simply use our 'Compare' feature. Search for the colleges you want to compare, and we'll show you a side-by-side view of their fees, placements, and infrastructure."
        }
    ];

    const [activeIndex, setActiveIndex] = useState(null);

    const toggleFAQ = (index) => {
        setActiveIndex(activeIndex === index ? null : index);
    };

    return (
        <section className="py-20 bg-brand-50 dark:bg-brand-900 border-t border-brand-100 dark:border-brand-800">
            <div className="container mx-auto px-4">
                <div className="text-center mb-12">
                    <div className="inline-flex items-center justify-center p-3 bg-action-100 dark:bg-action-900/30 rounded-full mb-4 text-action-600 dark:text-action-400">
                        <FiHelpCircle className="w-6 h-6" />
                    </div>
                    <h2 className="text-4xl font-bold text-brand-900 dark:text-white mb-4">
                        Frequently Asked Questions
                    </h2>
                    <p className="text-xl text-brand-600 dark:text-brand-400 max-w-2xl mx-auto">
                        Everything you need to know about the admission process and our platform.
                    </p>
                </div>

                <div className="max-w-3xl mx-auto space-y-4">
                    {faqs.map((faq, index) => (
                        <div
                            key={index}
                            className="bg-white dark:bg-brand-800 rounded-2xl overflow-hidden border border-brand-200 dark:border-brand-700 shadow-sm hover:shadow-md transition-shadow duration-300"
                        >
                            <button
                                onClick={() => toggleFAQ(index)}
                                className="w-full px-6 py-5 text-left flex items-center justify-between focus:outline-none"
                            >
                                <span className="text-lg font-semibold text-brand-900 dark:text-white pr-8">
                                    {faq.question}
                                </span>
                                <span className="text-action-500 flex-shrink-0">
                                    {activeIndex === index ? (
                                        <FiMinus className="w-6 h-6" />
                                    ) : (
                                        <FiPlus className="w-6 h-6" />
                                    )}
                                </span>
                            </button>

                            <AnimatePresence>
                                {activeIndex === index && (
                                    <motion.div
                                        initial={{ height: 0, opacity: 0 }}
                                        animate={{ height: "auto", opacity: 1 }}
                                        exit={{ height: 0, opacity: 0 }}
                                        transition={{ duration: 0.3, ease: "easeInOut" }}
                                    >
                                        <div className="px-6 pb-6 pt-0 text-brand-600 dark:text-brand-300 leading-relaxed border-t border-dashed border-brand-100 dark:border-brand-700 mt-2 pt-4">
                                            {faq.answer}
                                        </div>
                                    </motion.div>
                                )}
                            </AnimatePresence>
                        </div>
                    ))}
                </div>

                <div className="text-center mt-12">
                    <p className="text-brand-600 dark:text-brand-400 mb-4">
                        Still have questions? We're here to help!
                    </p>
                    <a
                        href="tel:9009536046"
                        className="inline-flex items-center font-semibold text-action-600 hover:text-action-700 dark:text-action-400 dark:hover:text-action-300 transition-colors"
                    >
                        Contact Support <span className="ml-2">→</span>
                    </a>
                </div>
            </div>
        </section>
    );
};

export default FAQ;
