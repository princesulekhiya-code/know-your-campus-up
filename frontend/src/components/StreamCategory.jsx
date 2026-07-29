import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';
import { FiArrowRight } from 'react-icons/fi';

const StreamCategory = () => {
    const categories = [
        {
            id: 1,
            title: "Engineering",
            count: "500+ Colleges",
            image: "https://images.unsplash.com/photo-1581092918056-0c4c3acd3789?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?stream=Engineering",
            color: "from-blue-600 to-blue-800"
        },
        {
            id: 2,
            title: "Medical (MBBS)",
            count: "50+ Colleges in MP",
            image: "https://images.unsplash.com/photo-1576091160550-2173dba999ef?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?search=MBBS",
            color: "from-emerald-600 to-emerald-800"
        },
        {
            id: 3,
            title: "Ayurveda (BAMS)",
            count: "30+ Colleges in MP",
            image: "https://images.unsplash.com/photo-1512290923902-8a9f81dc236c?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?search=BAMS",
            color: "from-green-600 to-green-800"
        },
        {
            id: 4,
            title: "Dental (BDS)",
            count: "15+ Colleges in MP",
            image: "https://images.unsplash.com/photo-1606811841689-23dfddce3e95?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?search=BDS",
            color: "from-cyan-600 to-cyan-800"
        },
        {
            id: 5,
            title: "Homeopathy (BHMS)",
            count: "10+ Colleges in MP",
            image: "https://images.unsplash.com/photo-1585435557343-3b092031a831?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?search=BHMS",
            color: "from-violet-600 to-violet-800"
        },
        {
            id: 6,
            title: "Physiotherapy (BPT)",
            count: "10+ Colleges in MP",
            image: "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?search=BPT",
            color: "from-rose-600 to-rose-800"
        },
        {
            id: 7,
            title: "Management",
            count: "400+ Colleges",
            image: "https://images.unsplash.com/photo-1556761175-5973dc0f32e7?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?stream=Management",
            color: "from-purple-600 to-purple-800"
        },
        {
            id: 8,
            title: "Commerce",
            count: "250+ Colleges",
            image: "https://images.unsplash.com/photo-1554224155-8d04cb21cd6c?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?stream=Commerce",
            color: "from-orange-600 to-orange-800"
        },
        {
            id: 9,
            title: "Law",
            count: "150+ Colleges",
            image: "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?auto=format&fit=crop&w=600&q=80",
            link: "/colleges?stream=Law",
            color: "from-red-600 to-red-800"
        }
    ];

    return (
        <section className="py-20 bg-brand-50 dark:bg-brand-900 border-b border-brand-200 dark:border-brand-800">
            <div className="container mx-auto px-4">
                <div className="flex flex-col md:flex-row justify-between items-end mb-12">
                    <div>
                        <h2 className="text-4xl font-bold text-brand-900 dark:text-white mb-2">
                            Browse by Stream
                        </h2>
                        <p className="text-xl text-brand-600 dark:text-brand-400">
                            MBBS, BAMS, BHMS, BDS, BPT, B.Tech &amp; more — Find your field
                        </p>
                    </div>
                    <Link to="/colleges" className="hidden md:flex items-center text-action-600 font-semibold hover:text-action-700 transition-colors">
                        View All Categories <FiArrowRight className="ml-2" />
                    </Link>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
                    {categories.map((category, index) => (
                        <Link to={category.link} key={category.id}>
                            <motion.div
                                initial={{ opacity: 0, scale: 0.9 }}
                                whileInView={{ opacity: 1, scale: 1 }}
                                viewport={{ once: true }}
                                transition={{ duration: 0.3, delay: index * 0.08 }}
                                whileHover={{ y: -5 }}
                                className="group relative rounded-2xl overflow-hidden h-56 cursor-pointer shadow-lg"
                            >
                                {/* Background Image */}
                                <img
                                    src={category.image}
                                    alt={`${category.title} colleges in Madhya Pradesh`}
                                    className="absolute inset-0 w-full h-full object-cover transition-transform duration-500 group-hover:scale-110"
                                    loading="lazy"
                                />

                                {/* Overlay */}
                                <div className={`absolute inset-0 bg-gradient-to-t ${category.color} opacity-80 group-hover:opacity-90 transition-opacity`}></div>

                                {/* Content */}
                                <div className="absolute inset-0 p-6 flex flex-col justify-end">
                                    <h3 className="text-2xl font-bold text-white mb-1">{category.title}</h3>
                                    <p className="text-white/80 font-medium mb-3">{category.count}</p>
                                    <div className="flex items-center text-white text-sm font-semibold opacity-0 group-hover:opacity-100 transform translate-y-2 group-hover:translate-y-0 transition-all duration-300">
                                        Explore Colleges <FiArrowRight className="ml-2" />
                                    </div>
                                </div>
                            </motion.div>
                        </Link>
                    ))}
                </div>

                <div className="mt-8 text-center md:hidden">
                    <Link to="/colleges" className="btn-outline inline-flex items-center">
                        View All Categories <FiArrowRight className="ml-2" />
                    </Link>
                </div>
            </div>
        </section>
    );
};

export default StreamCategory;
