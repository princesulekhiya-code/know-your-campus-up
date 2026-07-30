import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';
import { FiArrowRight } from 'react-icons/fi';

const StreamCategory = () => {
    const categories = [
        {
            id: 1,
            title: "Engineering",
            count: "500+ Colleges",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/MANIT_Bhopal_Main_Building.jpg/1200px-MANIT_Bhopal_Main_Building.jpg",
            link: "/colleges?stream=Engineering",
            color: "from-blue-600 to-blue-800"
        },
        {
            id: 2,
            title: "Medical (MBBS)",
            count: "50+ Colleges in MP",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
            link: "/colleges?search=MBBS",
            color: "from-emerald-600 to-emerald-800"
        },
        {
            id: 3,
            title: "Ayurveda (BAMS)",
            count: "30+ Colleges in MP",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
            link: "/colleges?search=BAMS",
            color: "from-green-600 to-green-800"
        },
        {
            id: 4,
            title: "Dental (BDS)",
            count: "15+ Colleges in MP",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Gajra_Raja_Medical_College_Gwalior.jpg/1200px-Gajra_Raja_Medical_College_Gwalior.jpg",
            link: "/colleges?search=BDS",
            color: "from-cyan-600 to-cyan-800"
        },
        {
            id: 5,
            title: "Homeopathy (BHMS)",
            count: "10+ Colleges in MP",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Gandhi_Medical_College_Bhopal.jpg/1200px-Gandhi_Medical_College_Bhopal.jpg",
            link: "/colleges?search=BHMS",
            color: "from-violet-600 to-violet-800"
        },
        {
            id: 6,
            title: "Physiotherapy (BPT)",
            count: "10+ Colleges in MP",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/AIIMS_Bhopal_Hospital_Building.jpg/1200px-AIIMS_Bhopal_Hospital_Building.jpg",
            link: "/colleges?search=BPT",
            color: "from-rose-600 to-rose-800"
        },
        {
            id: 7,
            title: "Management",
            count: "400+ Colleges",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/IIM_Indore_Campus.jpg/1200px-IIM_Indore_Campus.jpg",
            link: "/colleges?stream=Management",
            color: "from-purple-600 to-purple-800"
        },
        {
            id: 8,
            title: "Commerce",
            count: "250+ Colleges",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/IIM_Indore_Campus.jpg/1200px-IIM_Indore_Campus.jpg",
            link: "/colleges?stream=Commerce",
            color: "from-orange-600 to-orange-800"
        },
        {
            id: 9,
            title: "Law",
            count: "150+ Colleges",
            image: "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/IISER_Bhopal_LHC.jpg/1200px-IISER_Bhopal_LHC.jpg",
            link: "/colleges?stream=Law",
            color: "from-red-600 to-red-800"
        }
    ];

    return (
        <section className="py-16 bg-brand-50/50 dark:bg-brand-900/30">
            <div className="container mx-auto px-4">
                <div className="text-center max-w-3xl mx-auto mb-12">
                    <motion.h2
                        initial={{ opacity: 0, y: 20 }}
                        whileInView={{ opacity: 1, y: 0 }}
                        viewport={{ once: true }}
                        className="text-h2 font-bold text-brand-900 dark:text-white mb-4"
                    >
                        Browse by Stream
                    </motion.h2>
                    <motion.p
                        initial={{ opacity: 0, y: 20 }}
                        whileInView={{ opacity: 1, y: 0 }}
                        viewport={{ once: true }}
                        transition={{ delay: 0.1 }}
                        className="text-brand-600 dark:text-brand-400 text-lg"
                    >
                        Explore top colleges across various disciplines in MP & India
                    </motion.p>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
                    {categories.map((category, index) => (
                        <motion.div
                            key={category.id}
                            initial={{ opacity: 0, y: 20 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ delay: index * 0.05 }}
                        >
                            <Link to={category.link} className="block group">
                                <div className="relative h-64 rounded-2xl overflow-hidden shadow-md hover:shadow-xl transition-all duration-300 transform group-hover:-translate-y-1">
                                    {/* Image */}
                                    <img
                                        src={category.image}
                                        alt={category.title}
                                        className="w-full h-full object-cover group-hover:scale-110 transition-transform duration-500"
                                    />

                                    {/* Overlay */}
                                    <div className={`absolute inset-0 bg-gradient-to-t ${category.color} opacity-80 group-hover:opacity-90 transition-opacity`} />

                                    {/* Content */}
                                    <div className="absolute inset-0 p-6 flex flex-col justify-between text-white">
                                        <div className="flex justify-end">
                                            <span className="bg-white/20 backdrop-blur-md text-xs font-semibold px-3 py-1 rounded-full">
                                                {category.count}
                                            </span>
                                        </div>

                                        <div>
                                            <h3 className="text-2xl font-bold mb-2 flex items-center justify-between">
                                                <span>{category.title}</span>
                                                <FiArrowRight className="w-6 h-6 transform group-hover:translate-x-2 transition-transform" />
                                            </h3>
                                            <p className="text-white/80 text-sm">
                                                Explore top institutions & eligibility
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </Link>
                        </motion.div>
                    ))}
                </div>
            </div>
        </section>
    );
};

export default StreamCategory;
