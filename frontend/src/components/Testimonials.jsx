import { motion } from 'framer-motion';
import { FiStar } from 'react-icons/fi';
import { FaQuoteLeft } from 'react-icons/fa';

const Testimonials = () => {
    const testimonials = [
        {
            id: 1,
            name: "Rahul Sharma",
            college: "IIT Delhi - B.Tech CSE",
            image: "https://ui-avatars.com/api/?name=Rahul+Sharma&background=2563eb&color=fff&size=100",
            rating: 5,
            text: "Know Your Campus helped me find the perfect college! The detailed information about courses, fees, and placements made my decision so much easier. Highly recommended!",
            year: "2024"
        },
        {
            id: 2,
            name: "Priya Patel",
            college: "BITS Pilani - B.E. Electronics",
            image: "https://ui-avatars.com/api/?name=Priya+Patel&background=10b981&color=fff&size=100",
            rating: 5,
            text: "Amazing platform! I compared multiple colleges side-by-side and got all the information I needed. The admission process became so simple. Thank you!",
            year: "2023"
        },
        {
            id: 3,
            name: "Amit Kumar",
            college: "NIT Trichy - B.Tech Mechanical",
            image: "https://ui-avatars.com/api/?name=Amit+Kumar&background=f59e0b&color=fff&size=100",
            rating: 5,
            text: "The cutoff data and seat matrix information was incredibly accurate. It helped me make an informed decision about which college to apply to. Great work!",
            year: "2024"
        },
        {
            id: 4,
            name: "Sneha Reddy",
            college: "VIT Vellore - B.Tech IT",
            image: "https://ui-avatars.com/api/?name=Sneha+Reddy&background=8b5cf6&color=fff&size=100",
            rating: 5,
            text: "Best college finder platform! The team was very helpful and responsive. Got admission in my dream college. Couldn't have done it without this platform!",
            year: "2023"
        }
    ];

    return (
        <section className="py-20 bg-gradient-to-br from-brand-50 via-white to-action-50 dark:from-brand-900 dark:via-brand-900 dark:to-brand-800">
            <div className="container mx-auto px-4">
                {/* Header */}
                <motion.div
                    initial={{ opacity: 0, y: 20 }}
                    whileInView={{ opacity: 1, y: 0 }}
                    viewport={{ once: true }}
                    className="text-center mb-16"
                >
                    <h2 className="text-4xl md:text-5xl font-bold text-brand-900 dark:text-white mb-4">
                        Student Success Stories
                    </h2>
                    <p className="text-xl text-brand-600 dark:text-brand-400 max-w-2xl mx-auto">
                        Hear from students who found their dream colleges through our platform
                    </p>
                </motion.div>

                {/* Testimonials Grid */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
                    {testimonials.map((testimonial, index) => (
                        <motion.div
                            key={testimonial.id}
                            initial={{ opacity: 0, y: 30 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ duration: 0.5, delay: index * 0.1 }}
                            whileHover={{ y: -5 }}
                            className="bg-white dark:bg-brand-800 rounded-2xl p-6 shadow-soft hover:shadow-soft-lg transition-all duration-300 border border-brand-200 dark:border-brand-700 relative"
                        >
                            {/* Quote Icon */}
                            <div className="absolute top-4 right-4 text-action-200 dark:text-action-800">
                                <FaQuoteLeft className="w-8 h-8" />
                            </div>

                            {/* Student Info */}
                            <div className="flex items-center space-x-4 mb-4">
                                <img
                                    src={testimonial.image}
                                    alt={testimonial.name}
                                    className="w-16 h-16 rounded-full border-2 border-action-500"
                                />
                                <div>
                                    <h4 className="font-bold text-brand-900 dark:text-white">{testimonial.name}</h4>
                                    <p className="text-xs text-brand-600 dark:text-brand-400">{testimonial.college}</p>
                                </div>
                            </div>

                            {/* Rating */}
                            <div className="flex space-x-1 mb-4">
                                {[...Array(testimonial.rating)].map((_, i) => (
                                    <FiStar key={i} className="w-4 h-4 fill-yellow-400 text-yellow-400" />
                                ))}
                            </div>

                            {/* Testimonial Text */}
                            <p className="text-sm text-brand-700 dark:text-brand-300 leading-relaxed mb-4">
                                "{testimonial.text}"
                            </p>

                            {/* Year Badge */}
                            <div className="inline-block px-3 py-1 bg-action-50 dark:bg-action-900/30 text-action-700 dark:text-action-300 text-xs font-semibold rounded-full">
                                Class of {testimonial.year}
                            </div>
                        </motion.div>
                    ))}
                </div>

                {/* CTA */}
                <motion.div
                    initial={{ opacity: 0 }}
                    whileInView={{ opacity: 1 }}
                    viewport={{ once: true }}
                    className="text-center mt-12"
                >
                    <p className="text-brand-600 dark:text-brand-400 mb-4">
                        Join thousands of successful students!
                    </p>
                    <a
                        href="/admission"
                        className="btn-primary inline-block"
                    >
                        Start Your Journey
                    </a>
                </motion.div>
            </div>
        </section>
    );
};

export default Testimonials;
