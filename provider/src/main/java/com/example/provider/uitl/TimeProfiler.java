package com.example.provider.uitl;

/**
 * @Description 获取任务执行时间类
 * @Author songbo
 * @Date 2020/11/9 11:53
 * @Version 1.0
 */
public class TimeProfiler {

    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

    public static final void begin() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final Long end() {
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static final Long endSeconds() {
        return (System.currentTimeMillis() - TIME_THREAD_LOCAL.get()) / 1000;
    }

}
