import { motion } from 'framer-motion';

const LoadingSkeleton = ({ variant = 'card', count = 1 }) => {
    const renderSkeleton = () => {
        switch (variant) {
            case 'card':
                return (
                    <div className="card p-6 space-y-4">
                        <div className="skeleton h-6 w-3/4"></div>
                        <div className="skeleton h-4 w-full"></div>
                        <div className="skeleton h-4 w-5/6"></div>
                        <div className="flex gap-2 mt-4">
                            <div className="skeleton h-8 w-20"></div>
                            <div className="skeleton h-8 w-20"></div>
                        </div>
                    </div>
                );

            case 'list':
                return (
                    <div className="space-y-3">
                        {[...Array(count)].map((_, i) => (
                            <div key={i} className="flex items-center gap-4 p-4 card">
                                <div className="skeleton h-12 w-12 rounded-full flex-shrink-0"></div>
                                <div className="flex-1 space-y-2">
                                    <div className="skeleton h-4 w-3/4"></div>
                                    <div className="skeleton h-3 w-1/2"></div>
                                </div>
                            </div>
                        ))}
                    </div>
                );

            case 'text':
                return (
                    <div className="space-y-2">
                        {[...Array(count)].map((_, i) => (
                            <div key={i} className="skeleton h-4 w-full"></div>
                        ))}
                    </div>
                );

            default:
                return <div className="skeleton h-32 w-full rounded-lg"></div>;
        }
    };

    return (
        <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0 }}
            transition={{ duration: 0.2 }}
        >
            {renderSkeleton()}
        </motion.div>
    );
};

export default LoadingSkeleton;
