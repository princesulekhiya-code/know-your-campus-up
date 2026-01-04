import { motion } from 'framer-motion';
import { FiMail, FiSend } from 'react-icons/fi';

const Newsletter = () => {
    return (
        <section className="py-20 bg-brand-900 relative overflow-hidden">
            {/* Background Decorations */}
            <div className="absolute top-0 left-0 w-full h-full overflow-hidden opacity-10">
                <div className="absolute top-[-20%] left-[-10%] w-[500px] h-[500px] bg-action-500 rounded-full blur-[100px]" />
                <div className="absolute bottom-[-20%] right-[-10%] w-[500px] h-[500px] bg-blue-500 rounded-full blur-[100px]" />
            </div>

            <div className="container mx-auto px-4 relative z-10">
                <div className="max-w-4xl mx-auto bg-white/5 backdrop-blur-lg border border-white/10 rounded-3xl p-8 md:p-12 text-center shadow-2xl">
                    <motion.div
                        initial={{ opacity: 0, scale: 0.9 }}
                        whileInView={{ opacity: 1, scale: 1 }}
                        viewport={{ once: true }}
                    >
                        <div className="inline-flex items-center justify-center p-4 bg-action-500/10 rounded-full mb-6 text-action-400">
                            <FiMail className="w-8 h-8" />
                        </div>

                        <h2 className="text-3xl md:text-5xl font-bold text-white mb-6">
                            Stay Ahead of the Curve
                        </h2>
                        <p className="text-xl text-brand-200 mb-8 max-w-2xl mx-auto leading-relaxed">
                            Be the first to know about admission dates, scholarship opportunities, and exam notifications.
                        </p>

                        <div className="flex flex-col sm:flex-row gap-4 max-w-lg mx-auto">
                            <div className="flex-1 relative">
                                <input
                                    type="email"
                                    placeholder="Enter your email address"
                                    className="w-full px-6 py-4 rounded-full bg-white/10 border border-brand-700 text-white placeholder-brand-400 focus:outline-none focus:ring-2 focus:ring-action-400 focus:bg-white/20 transition-all backdrop-blur-md"
                                />
                            </div>
                            <button className="px-8 py-4 bg-action-600 hover:bg-action-700 text-white font-bold rounded-full transition-all shadow-lg hover:shadow-action-500/25 flex items-center justify-center gap-2 group">
                                Subscribe
                                <FiSend className="w-4 h-4 group-hover:translate-x-1 transition-transform" />
                            </button>
                        </div>

                        <p className="text-sm text-brand-400 mt-4">
                            Join 50,000+ students. No spam, fast updates.
                        </p>
                    </motion.div>
                </div>
            </div>
        </section>
    );
};

export default Newsletter;
