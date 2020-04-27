package com.wang.producer.component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/4/27 15:10
 * @since JDK 1.8
 */
public class ThreadPool {

//    private static final int cpu = Runtime.getRuntime().availableProcessors();
//    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(cpu,
//            cpu * 2,
//            60,
//            TimeUnit.SECONDS,
//            new LinkedBlockingQueue<>(10),
//            new ThreadFactory() {
//                @Override
//                public Thread newThread(Runnable r) {
//                    Thread thread = new Thread("自定义线程池");
//                    thread.setPriority(5);
//                    return thread;
//                }
//            });
//
//    public static ThreadPoolExecutor getThreadPoolExecutor() {
//        return pool;
//    }

    /**
     * 获取单例的普通线程池
     *
     * @return
     * @date 2018年12月20日 上午11:17:59
     * @author yang
     */
    public static final ThreadPoolExecutor getThreadPoolExecutor() {
        return CommonExecutorSingleton.INSTANCE;
    }

    /**
     * 创建普通线程池
     *
     * @author yang
     * @version 1.0
     * @date 2018年12月20日 上午11:24:20
     * @since JDK 1.8
     */
    private static class CommonExecutorSingleton {

        /**
         * 借助静态内部类创建单实例
         */
        private static final ThreadPoolExecutor INSTANCE = new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(200), new DefaultThreadFactory());

        /**
         * 默认线程池
         *
         * @author yang
         * @version 1.0
         * @date 2018年12月20日 上午11:21:26
         * @since JDK 1.8
         */
        private static class DefaultThreadFactory implements ThreadFactory {
            private static final AtomicInteger poolNumber = new AtomicInteger(1);
            private final ThreadGroup group;
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            private final String namePrefix;

            /**
             * Creates a new instance of DefaultThreadFactory.
             */
            public DefaultThreadFactory() {
                SecurityManager s = System.getSecurityManager();
                group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
                namePrefix = "spms-pool-" + poolNumber.getAndIncrement() + "-thread-";
            }

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
                if (t.isDaemon()) {
                    t.setDaemon(false);
                }
                if (t.getPriority() != Thread.NORM_PRIORITY) {
                    t.setPriority(Thread.NORM_PRIORITY);
                }
                return t;
            }
        }
    }
}
