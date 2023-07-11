package com.example.demo.cronjobs;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * @author zlxx
 */
@Component
public class ArchiveBookJob {
    private static final Logger logger = Logger.getLogger(ArchiveBookJob.class.getName());

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private BookMapper bookMapper;

    @Scheduled(cron = "0/10 * *  * * ? ")
    public void execute() {
        logger.info(String.format("开始执行归档任务,当前时间为:{%d}", System.currentTimeMillis()));
        List<Book> books = bookMapper.selectList(null);

        // 打印线程池参数
        logger.info(String.format("线程池参数: 核心线程数:{%d}, 最大线程数:{%d}, 队列大小:{%d}, 当前线程数:{%d}, 活跃线程数:{%d}, 已完成任务数:{%d}, 任务总数:{%d}",
                threadPoolExecutor.getCorePoolSize(),
                threadPoolExecutor.getMaximumPoolSize(),
                threadPoolExecutor.getQueue().size(),
                threadPoolExecutor.getPoolSize(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getTaskCount()));

        // 把books分为2份
        int pieceNum = (int) (books.size() / 2);
        for (int i = 0; i < 2; i++) {
            int start = i * pieceNum;
            int end;
            if (i == 1) {
                end = books.size();
            } else {
                end = (i + 1) * pieceNum;
            }
            Consumer<List<Book>> consumer = (List<Book> bookList) -> {
                logger.info(String.format("线程:{%s}, 开始处理book信息", Thread.currentThread().getName()));
                bookList.forEach(book -> {
                    // 打印线程，以及book信息
                    logger.info(String.format("线程:{%s}, book信息:{%s}", Thread.currentThread().getName(), book.toString()));
                });
            };
            Runnable run = () -> {
                consumer.accept(books.subList(start, end));
            };


            threadPoolExecutor.execute(run);
        }
        // 等待所有任务执行完毕
        while (threadPoolExecutor.getActiveCount() != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
